﻿using System;
using System.Linq;
using Microsoft.VisualStudio.Text.Tagging;

namespace DDDLanguage
{
	internal class DddOutlineTag : IOutliningRegionTag
	{
		private readonly string Lines;
		private readonly int Len;
		internal readonly string Rule;
		internal readonly int End;
		private string Text;

		public DddOutlineTag(string lines, int len, string rule, int end)
		{
			this.Lines = lines;
			this.Len = len;
			this.Rule = rule;
			this.End = end;
		}

		public object CollapsedForm { get { return "{ ... }"; } }
		public object CollapsedHintForm
		{
			get
			{
				if (Text == null)
				{
					var innerLines = Lines.Split('\n');
					var maxSpace = innerLines.Take(10).Where(it => !string.IsNullOrWhiteSpace(it)).Min(it => it.Length - it.TrimStart().Length);
					Text =
						string.Join("\n", innerLines.Take(10).Select(it => string.IsNullOrWhiteSpace(it) ? string.Empty : it.Substring(maxSpace)))
						+ (Len > 999 || innerLines.Where(it => it.Length > 0).Count() > 10 ? Environment.NewLine + "..." : string.Empty);
				}
				return Text;
			}
		}
		public bool IsDefaultCollapsed { get { return false; } }
		public bool IsImplementation { get { return false; } }
	}
}
