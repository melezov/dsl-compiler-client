import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;
import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;
import io.jvm.json.deserializers.LongArrayJsonDeserializer;
import io.jvm.json.deserializers.LongJsonDeserializer;
import io.jvm.json.serializers.LongArrayJsonSerializer;
import io.jvm.json.serializers.LongJsonSerializer;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.client.JsonSerialization;
import com.dslplatform.compiler.client.api.model.JSONTest.LongLegs;
import com.dslplatform.compiler.client.api.model.JSONTest.json.LongLegsJsonDeserializer;
import com.dslplatform.compiler.client.api.model.JSONTest.json.LongLegsJsonSerializer;
//import com.dslplatform.client.serialization.json.JsonDeserialization;
//import com.dslplatform.client.serialization.json.JsonSerialization;

public class EntryPoint {
    public static void main(final String[] args) throws Exception {
//        final JsonSerialization serialization = new JsonSerialization()
//            .register(new LongLegsJsonSerializer());
//
//        final JsonDeserialization deserialization = new JsonDeserialization()
//            .register(new LongLegsJsonDeserializer(null));

        final LongLegs ll = new LongLegs()
            .setOneLong(1L)
            .setOptLong(2L)
            .setArrLong(new long[] { 3L, 4L})
            .setArrOptLong(new Long[] { 5L, null, 6L })
            .setOptArrLong(new long[] { 7L, 8L })
            .setOptArrOptLong(new Long[] {9L, null, 10L})
            .setListLong(Arrays.asList(11L, 12L))
            .setListOptLong(Arrays.asList(13L, 14L))
            .setOptListLong(Arrays.asList(15L, 16L))
            .setOptListOptLong(Arrays.asList(17L, 18L))
            .setSetLong(new HashSet<Long>() {{ add(19L); add(20L); }} )
            .setSetOptLong(new HashSet<Long>() {{ add(19L); add(null); add(20L); }} )
            .setOptSetLong(new HashSet<Long>() {{ add(19L); add(20L); }} )
            .setOptSetOptLong(new HashSet<Long>() {{ add(19L); add(null); add(20L); }} );
            ;
        System.out.println(ll);

        final JsonSerialization js = Bootstrap.init(System.getProperty("user.home") + "/.config/dsl-compiler-client/dsl-project.ini").resolve(JsonSerialization.class);

        final JsonSerializer<LongLegs> serLL;
        final JsonDeserializer<LongLegs> desLL;
        {
            System.out.println("---------------------------");
            final StringWriter sw = new StringWriter();
            serLL = new LongLegsJsonSerializer(new LongJsonSerializer(), new LongArrayJsonSerializer());
            serLL.toJson(new JsonWriter(sw), ll);
            final String llSer = sw.toString();
            System.out.println(llSer);

            final StringReader sr = new StringReader(llSer);
            desLL = new LongLegsJsonDeserializer(null, new LongJsonDeserializer(), new LongArrayJsonDeserializer());
            final LongLegs llDes = desLL.fromJson(new JsonReader(sr));
            System.out.println(llDes);

            System.out.println(ll.equals(llDes));
        }

        final JsonSerializer<LongLegs> serLL2;
        {
            System.out.println("---------------------------");
            final StringWriter sw = new StringWriter();
            serLL2 = new LongLegsJsonSerializer(new LongJsonSerializer(),
                    new LongArrayJsonSerializer());

            serLL2.toJson(new JsonWriter(sw), ll);
            final String llSer = sw.toString();
            System.out.println(llSer);
        }


        for (int r = 0; r < 10; r ++) {
            {
                final long startedAt = System.currentTimeMillis();
                for (int i = 0; i < 100000; i ++) {
                    js.serialize(ll);
                }
                final long endedAt = System.currentTimeMillis();
                System.out.println("JACKSON: " + (endedAt - startedAt) + " ms");
            }

            {
                final long startedAt = System.currentTimeMillis();
                for (int i = 0; i < 100000; i ++) {
                    final StringWriter sw = new StringWriter();
                    serLL.toJson(new JsonWriter(sw), ll);
                    final String llSer = sw.toString();
                }
                final long endedAt = System.currentTimeMillis();
                System.out.println("DSL: " + (endedAt - startedAt) + " ms");
            }

            {
                final long startedAt = System.currentTimeMillis();
                for (int i = 0; i < 100000; i ++) {
                    final StringWriter sw = new StringWriter();
                    serLL2.toJson(new JsonWriter(sw), ll);
                    final String llSer = sw.toString();
                }
                final long endedAt = System.currentTimeMillis();
                System.out.println("DSL2: " + (endedAt - startedAt) + " ms");
            }
        }

//
//        final MummyVal mv = new MummyVal()
//            .setOneLL(new LongLegs().setOneLong(1L))
//            .setOptLL(new LongLegs().setOneLong(2L))
//            .setArrLL(new LongLegs[] { new LongLegs().setOneLong(3L), new LongLegs().setOneLong(4L) })
//            .setArrOptLL(new LongLegs[] { new LongLegs().setOneLong(5L), null, new LongLegs().setOneLong(6L) })
//            .setOptArrLL(new LongLegs[] { new LongLegs().setOneLong(7L), new LongLegs().setOneLong(8L) })
//            .setOptArrOptLL(new LongLegs[] { new LongLegs().setOneLong(9L), null, new LongLegs().setOneLong(10L) })
//            .setListLL(new ArrayList<LongLegs>() {{ add(new LongLegs().setOneLong(11L)); add(new LongLegs().setOneLong(12L)); }})
//            .setListOptLL(new ArrayList<LongLegs>() {{ add(new LongLegs().setOneLong(13L)); add(null); add(new LongLegs().setOneLong(14L)); }})
//            .setOptListLL(new ArrayList<LongLegs>() {{ add(new LongLegs().setOneLong(15L)); add(new LongLegs().setOneLong(16L)); }})
//            .setOptListOptLL(new ArrayList<LongLegs>() {{ add(new LongLegs().setOneLong(17)); add(null); add(new LongLegs().setOneLong(18L)); }});
//
//        System.out.println(mv);
//



//
////        System.out.println("------------------------------------------");
////        System.out.println(JsonSerialization.serialize(ll));
////        System.out.println(JsonSerialization.serialize(mv));
//
//        final JsonSerializer<MummyVal> serMV;
//        final JsonDeserializer<MummyVal> desMV;
//        {
//            System.out.println("---------------------------");
//            final StringWriter sw = new StringWriter();
//            serMV = new MummyValJsonSerializer(serLL);
//            serMV.toJson(new JsonWriter(sw), mv);
//            final String mvSer = sw.toString();
//            System.out.println(mvSer);
//
//            final StringReader sr = new StringReader(mvSer);
//            desMV = new MummyValJsonDeserializer(null, desLL);
//            final MummyVal mvDes = desMV.fromJson(new JsonReader(sr));
//            System.out.println(mvDes);
//
//
//            System.out.println("-----------------------");
//
//            System.out.println(js.serialize(mv));
//            System.out.println(js.serialize(mvDes));
//
//            System.out.println("-----------------------");
//
//            final StringWriter sw1 = new StringWriter();
//            serMV.toJson(new JsonWriter(sw1), mv);
//            System.out.println(sw1);
//
//            final StringWriter sw2 = new StringWriter();
//            serMV.toJson(new JsonWriter(sw2), mvDes);
//            System.out.println(sw2);
//
//            System.out.println(sw1.toString().equals(sw2.toString()));
//        }

//        System.out.println("-----------------------");
//
//        final Guidlicious gg = new Guidlicious()
//            .setOneGuid(UUID.fromString("1-2-3-4-5"))
//            .setOptGuid(UUID.fromString("0-0-0-0-0"))
//            .setArrGuid(new UUID[] { UUID.randomUUID(), UUID.randomUUID()})
//            .setArrOptGuid(new UUID[] { UUID.randomUUID(), null, UUID.randomUUID() })
//            .setOptArrGuid(new UUID[] {  })
//            .setOptArrOptGuid(new UUID[] { null})
//            .setListGuid(Arrays.asList(UUID.randomUUID()))
//            .setListOptGuid(Arrays.asList(UUID.randomUUID()))
//            .setOptListGuid(Arrays.asList(UUID.randomUUID(), UUID.randomUUID()))
//            .setOptListOptGuid(Arrays.asList(UUID.randomUUID(), null, UUID.randomUUID()))
//            .setSetGuid(new HashSet<UUID>() {{ add(UUID.randomUUID()); add(UUID.randomUUID()); }} )
//            .setSetOptGuid(new HashSet<UUID>() {{ add(UUID.randomUUID()); add(null); add(UUID.randomUUID()); }} )
//            .setOptSetGuid(new HashSet<UUID>() {{ add(UUID.randomUUID()); add(UUID.randomUUID()); }} )
//            .setOptSetOptGuid(new HashSet<UUID>() {{ add(UUID.randomUUID()); add(null); add(UUID.randomUUID()); }} );
//        System.out.println(gg);
//
//        final JsonSerializer<Guidlicious> serGG;
//        final JsonDeserializer<Guidlicious> desGG;
//        {
//            System.out.println("---------------------------");
//            final StringWriter sw = new StringWriter();
//            serGG = new GuidliciousJsonSerializer(new UUIDJsonSerializer());
//            serGG.toJson(new JsonWriter(sw), gg);
//            final String ggSer = sw.toString();
//            System.out.println(ggSer);
//
//            final StringReader sr = new StringReader(ggSer);
//            desGG = new GuidliciousJsonDeserializer(null, new JsonDeserializers.UUIDJsonDeserializer());
//            final Guidlicious ggDes = desGG.fromJson(new JsonReader(sr));
//            System.out.println(ggDes);
//
//            System.out.println(js.serialize(gg));
//            System.out.println(js.serialize(ggDes));
//
//            System.out.println(gg.equals(ggDes));
//
////            System.out.println(ll.equals(llDes));
//        }

//        System.out.println("-----------------------");
//
//        final StringlyTyped st = new StringlyTyped()
//            .setOneStr("one")
//            .setOptStr("opt")
//            .setArrStr(new String[] { "a", "r", "r"})
//            .setArrOptStr(new String[] { "o", null, "p", null, "t" })
//            .setOptArrStr(new String[] {  })
//            .setOptArrOptStr(new String[] { null })
//            .setListStr(Arrays.asList("l", "i", "s", "t"))
//            .setListOptStr(Arrays.asList( "o", null, "p", null, "t" ))
//            .setOptListStr(Arrays.asList( "op", "et" ))
//            .setOptListOptStr(Arrays.asList( "X", null, "Y" ))
//            .setSetStr(new HashSet<String>() {{ add("a"); add("b"); }} )
//            .setSetOptStr(new HashSet<String>() {{ add("c"); add(null); add("d"); }} )
//            .setOptSetStr(new HashSet<String>() {{ add("e"); add("f"); }} )
//            .setOptSetOptStr(new HashSet<String>() {{ add("g"); add("h"); add(null); }} );
//        System.out.println(st);
//
//        final JsonSerializer<StringlyTyped> serST;
//        final JsonDeserializer<StringlyTyped> desST;
//        {
//            System.out.println("---------------------------");
//            final StringWriter sw = new StringWriter();
//            serST = new StringlyTypedJsonSerializer(new StringJsonSerializer());
//            serST.toJson(new JsonWriter(sw), st);
//            final String stSer = sw.toString();
//            System.out.println(stSer);
//
////            final StringReader sr = new StringReader(ggSer);
////            desGG = new StringlyTypedJsonDeserializer(null, new JsonDeserializers.StringJsonDeserializer());
////            final StringlyTyped ggDes = desGG.fromJson(new JsonReader(sr));
////            System.out.println(ggDes);
//
//            System.out.println(js.serialize(st));
////            System.out.println(js.serialize(stDes));
////
////            System.out.println(st.equals(stDes));
//
////            System.out.println(ll.equals(llDes));
//        }



    }
}

//        {
//            final LongLegs ll = new LongLegs();
//            System.out.println(ll);
//
//            final StringWriter sw = new StringWriter();
//            new LongLegsJsonSerializer().toJson(new JsonWriter(sw), ll);
//            final String llSer = sw.toString();
//            System.out.println(llSer);
//
//            final StringReader sr = new StringReader(llSer);
//            final JsonDeserializer<LongLegs> d = new LongLegsJsonDeserializer(null);
//            final LongLegs llDes = d.fromJson(new JsonReader(sr));
//            System.out.println(llDes);
//
//            System.out.println(ll.equals(llDes));
//        }



//        final String xs = "0,-0,0.,-0.,0.0,-0.0,0.123,-0.123,0.1a2" +
//                         "1,-1,1.,-1.,1.0,-1.0,1.123,-1.123,1.1a2" +
//                         "12,-12,12.,-12.,12.0,-12.0,12.123,-12.123,12.1a2," +
//                         "0.12E+20,0.12E-20,0.12E20,0.12E+,0.12E+a20,0.12E+20a";
//
//        for (final String x : xs.split(",")) {
//            System.out.println("---------------");
//            System.out.println("Parsing [" + x + "]:");
//            final JsonReader p = new JsonReader(new StringReader(x));
//            try {
//                System.out.println("OK: >" + p.readRawNumber(new StringBuilder()) + "<");
//            }
//            catch (final IOException e) {
//                System.out.println("ERROR:");
//                e.printStackTrace(System.out);
//            }
//        }

//        System.out.println(new JsonReader(new StringReader("100")).readByte());
//        System.out.println(new JsonReader(new StringReader("10000")).readShort());
//        for (final short s : new JsonReader(new StringReader("[10000,1E4,100000000000000E-10]")).readShortArray()) System.out.print(s + "|");
//        System.out.println(new JsonReader(new StringReader("1000000000")).readInt());
//        for (final int i : new JsonReader(new StringReader("[10000000,1E7,100000000000000000E-10]")).readIntArray()) System.out.print(i + "|");
//        System.out.println(new JsonReader(new StringReader("10000000000000")).readLong());
//        for (final long l : new JsonReader(new StringReader("[100000000000.1,1E12,10000000000000000000000E-10]")).readLongArray()) System.out.print(l + "|");
//        System.out.println(new JsonReader(new StringReader("1.00000000001")).readFloat());
//      for (final float f : new JsonReader(new StringReader("[100000000000.1,1E12,10000000000000000000000E-10]")).readLongArray()) System.out.print(f + "|");
//        System.out.println(new JsonReader(new StringReader("1.00000000001")).readDouble());
//      for (final double d : new JsonReader(new StringReader("[100000000000.1,1E12,10000000000000000000000E-10]")).readLongArray()) System.out.print(d + "|");
//        System.out.println(new JsonReader(new StringReader("true")).readBoolean());
//        for (final boolean b : new JsonReader(new StringReader("[true,false,true]")).readBooleanArray()) System.out.print(b + "|");
//        System.out.println(new JsonReader(new StringReader("\"X\"")).readChar());
//        for (final char c : new JsonReader(new StringReader("\"[true,fal\\\"se,true]\"")).readCharArray()) System.out.print(c + "|");
//        System.out.println(new JsonReader(new StringReader("\"0.0\"")).readString());
//        for (final String s : new JsonReader(new StringReader("[\"[true,fal\\\"se,true]\",\"null\"]")).readStringArray()) System.out.print(s + "|");


        //deserialization.deserialize(x, int.class);


//        final String[] tests = { "12345", "\"\"", "null", "nullx", "nul", "\"opened", "\"closed\"x" };
//
//        for (final String test: tests) {
//            System.out.println("-------------------");
//            System.out.println("Parsing: " + test);
//            try {
//                final String s = deserialization.deserialize(test, String.class);
//                System.out.println("OK: " + s);
//            }
//            catch (final Exception e) {
//                System.out.println("ERROR: ");
//                e.printStackTrace();
//            }
//        }
//
//        for (final String catTest : new String[] {
//                "null",
//                "[]",
//                "[\"\"]",
//                "[\"\",\"\"]",
//                "[null,\"\"]",
//                "[null,null]",
//                "[\"\",null]",
//                "[\"\",\"null\",null,\"A quote is ->\\\"<- there\",\"/\\\\__\\/\\\\\"]"
//                }) {
//
//
//            System.out.println("----------------------");
//            System.out.println("Parsing: " + catTest);
//            try {
//                final List<String> res = deserialization.deserialize(catTest, String.class, new ArrayList<String>());
//                if (res == null) {
//                    System.out.println(res);
//                }
//                else if (res.isEmpty()) {
//                    System.out.println("<empty>");
//                }
//                else {
//                    for (int i = 0; i < res.size(); i ++) {
//                        System.out.println(i + ": [" + res.get(i) + "]");
//                    }
//                }
//            }
//            catch (final Exception e) {
//                System.out.println("ERROR: ");
//                e.printStackTrace();
//            }
//        }
//
//        for (final String catTest : new String[] {
//                "null",
//                "[]",
//                "[\"\"]",
//                "[\"\",\"\"]",
//                "[null,\"\"]",
//                "[null,null]",
//                "[\"\",null]",
//                "[\"\",\"null\",null,\"A quote is ->\\\"<- there\",\"/\\\\__\\/\\\\\"]"
//                }) {
//
//
//            System.out.println("----------------------");
//            System.out.println("Parsing: " + catTest);
//            try {
//                final String[] res = deserialization.deserialize(catTest, String[].class);
//                if (res == null) {
//                    System.out.println(res);
//                }
//                else if (res.length == 0) {
//                    System.out.println("<empty>");
//                }
//                else {
//                    for (int i = 0; i < res.length; i ++) {
//                        System.out.println(i + ": [" + res[i] + "]");
//                    }
//                }
//            }
//            catch (final Exception e) {
//                System.out.println("ERROR: ");
//                e.printStackTrace();
//            }
//        }
//
//        final List<String[][]> keke = deserialization.deserialize("[[[\"X\\\"Y\"]],[[\"a\",\"b\"],[\"c\",\"d\",null]]]", String[][].class, new ArrayList<String[][]>());
//        final JsonSerialization serialization = new JsonSerialization();
//        System.out.println(serialization.serialize(new ArrayList() {{ add(keke); }} ));
//
//        final String bodyArr = "[{'ID':'6317ae03-c495-4f9a-b0c7-f764472207df','UserID':'marko@element.hr','CreatedAt':'2014-02-20T18:06:07.978391+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_b903d07c2047f2885e598f','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_b903d07c2047f2885e598f','ApplicationPoolName':'beta_b903d07c2047f2885e598f','Nick':'SimonDemo','URI':'6317ae03-c495-4f9a-b0c7-f764472207df','UserURI':'marko@element.hr'},{'ID':'b06f7bd7-f3ad-4383-834a-ed42250b4d81','UserID':'marko@element.hr','CreatedAt':'2014-02-18T05:45:27.649201+01:00','DatabaseServer':'10.5.17.1','DatabasePort':5432,'DatabaseName':'extest_00','ApplicationServer':'localhost','ApplicationName':'extest','ApplicationPoolName':'beta_b2ca79c5304a99888b5113','Nick':'extest','CustomDatabaseAdmin':'extest','CustomDatabasePassword':'extest3000','IsExternal':true,'URI':'b06f7bd7-f3ad-4383-834a-ed42250b4d81','UserURI':'marko@element.hr'},{'ID':'15e5faac-2e9e-4da2-91a3-543982cc256f','UserID':'marko@element.hr','CreatedAt':'2014-02-18T03:52:24.523886+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_14a79f5b59400987ef4425','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_14a79f5b59400987ef4425','ApplicationPoolName':'beta_14a79f5b59400987ef4425','Nick':'GreenKouprey','URI':'15e5faac-2e9e-4da2-91a3-543982cc256f','UserURI':'marko@element.hr'},{'ID':'1ebf04dd-268a-451c-b78e-7cf8f2f9a2f2','UserID':'marko@element.hr','CreatedAt':'2014-02-12T15:06:58.665532+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_66312aba24472fb52a575f','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_66312aba24472fb52a575f','ApplicationPoolName':'beta_66312aba24472fb52a575f','Nick':'MaliERP','URI':'1ebf04dd-268a-451c-b78e-7cf8f2f9a2f2','UserURI':'marko@element.hr'},{'ID':'63812f35-548d-4cad-8f1a-7f2534a7c687','UserID':'marko@element.hr','CreatedAt':'2014-02-10T17:04:18.286375+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_8b633ad3c549c0a8f3b778','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_8b633ad3c549c0a8f3b778','ApplicationPoolName':'beta_8b633ad3c549c0a8f3b778','Nick':'NgsUtilClient','URI':'63812f35-548d-4cad-8f1a-7f2534a7c687','UserURI':'marko@element.hr'},{'ID':'3b3e1ec0-bdf3-46a7-a08a-eaa99528c2c7','UserID':'marko@element.hr','CreatedAt':'2014-01-30T00:44:46.855651+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_9aca26514249aaaa17d01e','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_9aca26514249aaaa17d01e','ApplicationPoolName':'beta_9aca26514249aaaa17d01e','Nick':'CyanWoodpecker','URI':'3b3e1ec0-bdf3-46a7-a08a-eaa99528c2c7','UserURI':'marko@element.hr'},{'ID':'5ef20bb0-3b70-4466-8c22-0a32942adfe6','UserID':'marko@element.hr','CreatedAt':'2014-01-25T01:49:44.564978+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_0d712988e440018612ce51','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_0d712988e440018612ce51','ApplicationPoolName':'beta_0d712988e440018612ce51','Nick':'WhiteCheetah','URI':'5ef20bb0-3b70-4466-8c22-0a32942adfe6','UserURI':'marko@element.hr'},{'ID':'2f718abf-667c-4b38-94bd-8752daba2fd6','UserID':'marko@element.hr','CreatedAt':'2014-01-21T17:33:46.242832+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_7ef1d9208644f8b94b2924','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_7ef1d9208644f8b94b2924','ApplicationPoolName':'beta_7ef1d9208644f8b94b2924','Nick':'SilverShrew','URI':'2f718abf-667c-4b38-94bd-8752daba2fd6','UserURI':'marko@element.hr'},{'ID':'10faae1c-e3db-4e67-ad20-a931b784b38c','UserID':'marko@element.hr','CreatedAt':'2014-01-20T03:48:26.276495+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_590bd1d6d142e7aa8995b4','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_590bd1d6d142e7aa8995b4','ApplicationPoolName':'beta_590bd1d6d142e7aa8995b4','Nick':'YellowSpider','URI':'10faae1c-e3db-4e67-ad20-a931b784b38c','UserURI':'marko@element.hr'},{'ID':'b0353d6e-8968-4488-a046-4882e6cd6de3','UserID':'marko@element.hr','CreatedAt':'2014-01-08T18:24:25.250126+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_66b85af7c84cda84b0f410','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_66b85af7c84cda84b0f410','ApplicationPoolName':'beta_66b85af7c84cda84b0f410','Nick':'MindBlank','URI':'b0353d6e-8968-4488-a046-4882e6cd6de3','UserURI':'marko@element.hr'},{'ID':'819286e1-c6bb-4b10-8a5f-664aa02a1339','UserID':'marko@element.hr','CreatedAt':'2013-12-26T12:17:04.821771+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_ccda32b2fd4e1187b59879','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_ccda32b2fd4e1187b59879','ApplicationPoolName':'beta_ccda32b2fd4e1187b59879','Nick':'ScalaSeconder','URI':'819286e1-c6bb-4b10-8a5f-664aa02a1339','UserURI':'marko@element.hr'},{'ID':'09779f1b-505e-4464-ba02-272877123467','UserID':'marko@element.hr','CreatedAt':'2013-12-26T08:35:48.048651+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_d83f6026044faa90bd9a23','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_d83f6026044faa90bd9a23','ApplicationPoolName':'beta_d83f6026044faa90bd9a23','Nick':'ScalaPrimer','URI':'09779f1b-505e-4464-ba02-272877123467','UserURI':'marko@element.hr'},{'ID':'cb02db1c-beb0-4745-a5e1-d4367d66ea4c','UserID':'marko@element.hr','CreatedAt':'2013-12-04T18:11:16.389527+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_114e4953734dc5a816d133','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_114e4953734dc5a816d133','ApplicationPoolName':'beta_114e4953734dc5a816d133','Nick':'Adept','URI':'cb02db1c-beb0-4745-a5e1-d4367d66ea4c','UserURI':'marko@element.hr'},{'ID':'40a2406a-f9d4-418f-a18e-f5bb8ad333ce','UserID':'marko@element.hr','CreatedAt':'2013-12-02T17:35:35.919461+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_045f0d549046d4ad14dd97','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_045f0d549046d4ad14dd97','ApplicationPoolName':'beta_045f0d549046d4ad14dd97','Nick':'USHR','URI':'40a2406a-f9d4-418f-a18e-f5bb8ad333ce','UserURI':'marko@element.hr'},{'ID':'1fc5b445-45db-4703-9539-7c08a0b33459','UserID':'marko@element.hr','CreatedAt':'2013-12-02T15:17:30.042907+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_c1fac3b78845f3a174c0d8','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_c1fac3b78845f3a174c0d8','ApplicationPoolName':'beta_c1fac3b78845f3a174c0d8','Nick':'ScalaExchange','URI':'1fc5b445-45db-4703-9539-7c08a0b33459','UserURI':'marko@element.hr'},{'ID':'7e6a6480-a2bd-41b7-bd35-81759de2b563','UserID':'marko@element.hr','CreatedAt':'2013-11-29T16:50:17.725247+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_fc6961eea04246a0882e52','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_fc6961eea04246a0882e52','ApplicationPoolName':'beta_fc6961eea04246a0882e52','Nick':'OrangeHippopotamus','URI':'7e6a6480-a2bd-41b7-bd35-81759de2b563','UserURI':'marko@element.hr'},{'ID':'93964af8-83d5-4b5a-ac70-d27f48b96125','UserID':'marko@element.hr','CreatedAt':'2013-11-28T14:20:09.283671+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_623f8ae48b4ed7b00bc6c9','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_623f8ae48b4ed7b00bc6c9','ApplicationPoolName':'beta_623f8ae48b4ed7b00bc6c9','Nick':'ScarletNightingale','URI':'93964af8-83d5-4b5a-ac70-d27f48b96125','UserURI':'marko@element.hr'},{'ID':'803307fd-41a0-47a4-ae44-5e2485ccb4e7','UserID':'marko@element.hr','CreatedAt':'2013-11-28T11:29:25.229278+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_c85cdc16c14464b4c87a2b','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_c85cdc16c14464b4c87a2b','ApplicationPoolName':'beta_c85cdc16c14464b4c87a2b','Nick':'InfinumDemo','URI':'803307fd-41a0-47a4-ae44-5e2485ccb4e7','UserURI':'marko@element.hr'},{'ID':'afba6959-e1a4-47c6-aa31-53a7d420ab1d','UserID':'marko@element.hr','CreatedAt':'2013-11-26T22:13:59.110774+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_98ab6e5b9e4764becd6e64','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_98ab6e5b9e4764becd6e64','ApplicationPoolName':'beta_98ab6e5b9e4764becd6e64','Nick':'VioletPanther','URI':'afba6959-e1a4-47c6-aa31-53a7d420ab1d','UserURI':'marko@element.hr'},{'ID':'130fee97-fa2c-4c66-a84a-edb0ce78ad26','UserID':'marko@element.hr','CreatedAt':'2013-11-26T22:13:48.205354+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_c193c155174b2ca1a24671','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_c193c155174b2ca1a24671','ApplicationPoolName':'beta_c193c155174b2ca1a24671','Nick':'Test1','URI':'130fee97-fa2c-4c66-a84a-edb0ce78ad26','UserURI':'marko@element.hr'},{'ID':'8124eb6d-c71a-41a4-a93f-d734cb7471db','UserID':'marko@element.hr','CreatedAt':'2013-11-26T17:18:00.463981+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_11522cd239425f97d759c9','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_11522cd239425f97d759c9','ApplicationPoolName':'beta_11522cd239425f97d759c9','Nick':'ElemicaDemo','URI':'8124eb6d-c71a-41a4-a93f-d734cb7471db','UserURI':'marko@element.hr'},{'ID':'f6f6c06c-c458-4198-ad92-78eb54c63d56','UserID':'marko@element.hr','CreatedAt':'2013-11-22T18:25:11.783123+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_1715f531d94dd786711093','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_1715f531d94dd786711093','ApplicationPoolName':'beta_1715f531d94dd786711093','Nick':'nautic','URI':'f6f6c06c-c458-4198-ad92-78eb54c63d56','UserURI':'marko@element.hr'},{'ID':'24c02e84-c77e-4b32-bca6-f8968620effc','UserID':'marko@element.hr','CreatedAt':'2013-07-05T10:52:49.686308+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'alpha_8c08654b384feea9826476','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'alpha_8c08654b384feea9826476','ApplicationPoolName':'alpha_8c08654b384feea9826476','Nick':'EIndex3','URI':'24c02e84-c77e-4b32-bca6-f8968620effc','UserURI':'marko@element.hr'}]";
//      final String body = "{'ID':'6317ae03-c495-4f9a-b0c7-f764472207df','UserID':'marko@element.hr','CreatedAt':'2014-02-20T18:06:07.978391+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_b903d07c2047f2885e598f','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_b903d07c2047f2885e598f','ApplicationPoolName':'beta_b903d07c2047f2885e598f','Nick':'SimonDemo','URI':'6317ae03-c495-4f9a-b0c7-f764472207df','UserURI':'marko@element.hr'}"
//              .replace('\'', '"');
//
//      deserialization.register(new ProjectJsonDeserialization(null, null));
//
//      final String numbers = "0,0.1,0.12,0e0,0e+0,0e-01,0.123e+123,10,10.1,10.12,10e0,10e+0,10e-01,10.123e+123";
//
//      final String xxx = ("{'keke\\'QZxxxx':null,'k':["+numbers+"],'keke':false,'keke':null,'keke':true,'abraham':{'a':'b'},'godfanzin':[false,true]}123")
//              .replace('\'', '"');
//
//      final JsonReader r = new JsonReader(new StringReader(xxx));
//
//      System.out.println(r.readRaw());
//
//      System.out.println(r.read());
//      System.out.println(r.next());
//      System.out.println(r.read());
//
//
//
//
//
//
//        for (String[][] c1 : keke) {
//            for (String[] cur : c1) {
//            for (String s : cur) {
//                System.out.println(cur + " = = " + s);
//            }
//        }
//        }
//        System.out.println(keke);
