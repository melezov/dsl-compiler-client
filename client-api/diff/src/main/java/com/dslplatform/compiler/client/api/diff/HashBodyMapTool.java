package com.dslplatform.compiler.client.api.diff;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

import com.dslplatform.compiler.client.util.Hash;

public class HashBodyMapTool {
    public static Map<String, PathAction> compareHashBodyMaps(
            final Map<Hash, SortedSet<String>> srcBodies,
            final Map<Hash, SortedSet<String>> dstBodies) {
        if (srcBodies == null) throw new IllegalArgumentException("srcBodies cannot be null");
        if (dstBodies == null) throw new IllegalArgumentException("dstBodies cannot be null");

        final TreeMap<String, PathAction> result = new TreeMap<String, PathAction>();

        final Map<String, Hash> srcMap = new TreeMap<String, Hash>();
        for (final Map.Entry<Hash, SortedSet<String>> srcEntry : srcBodies.entrySet()) {
            final SortedSet<String> srcPaths = srcEntry.getValue();
            final Hash srcHash = srcEntry.getKey();

            for (final String srcPath : srcPaths) {
                srcMap.put(srcPath, srcHash);
            }
        }

        for (final Map.Entry<Hash, SortedSet<String>> dstEntry : dstBodies.entrySet()) {
            final SortedSet<String> dstPaths = dstEntry.getValue();
            final Hash dstHash = dstEntry.getKey();

            for (final String dstPath : dstPaths) {
                final Hash srcHash = srcMap.get(dstPath);

                // old file exists at new file path
                if (srcHash != null) {
                    // check if file was changed
                    if (dstHash.equals(srcHash)) {
                        result.put(dstPath, new PathAction(dstPath, null, srcHash, ChangeAction.NO_CHANGE));
                    } else {
                        result.put(dstPath, new PathAction(dstPath, null, srcHash, ChangeAction.MODIFIED));
                    }
                    srcMap.remove(dstPath);
                } else { // old file doesn't exist
                    final SortedSet<String> srcPaths = srcBodies.get(dstHash);
                    if (srcPaths != null) {
                        // file exists somewhere else assume first in set
                        final String sourcePath = srcPaths.first();
                        result.put(sourcePath, new PathAction(sourcePath, dstPath, srcHash, ChangeAction.MOVED));

                        // cleanup
                        srcPaths.remove(sourcePath);
                        if (srcPaths.isEmpty()) {
                            srcBodies.remove(dstHash);
                        }
                        srcMap.remove(sourcePath);
                    } else {
                        // Hash not found in oldBodies, mark file as new or copy file is new if
                        // first in set, otherwise copy of first in set
                        final String firstDstPath = dstPaths.first();
                        if (dstPath.equals(firstDstPath)) {
                            result.put(dstPath, new PathAction(dstPath, null, dstHash, ChangeAction.CREATED));
                        } else {
                            result.put(dstPath, new PathAction(firstDstPath, dstPath, dstHash, ChangeAction.COPIED));
                        }
                    }
                }
            }
        }

        // leftover files in oldMap are to be deleted
        for (final Map.Entry<String, Hash> srcEntry : srcMap.entrySet()) {
            final String srcPath = srcEntry.getKey();
            result.put(srcPath, new PathAction(srcPath, null, srcEntry.getValue(), ChangeAction.DELETED));
        }

        return result;
    }
}
