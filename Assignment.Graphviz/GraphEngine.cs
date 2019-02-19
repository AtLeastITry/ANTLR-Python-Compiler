using System;
using System.Diagnostics;
using System.IO;
using System.Reflection;

namespace Assignment.Graphviz
{
    public static class GraphEngine
    {

        private static Process BuildProcess(string filePath)
        {
            var process = new Process();
            process.StartInfo.RedirectStandardOutput = true;
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.CreateNoWindow = true;
            process.StartInfo.FileName = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location) + @"\Lib\dot.exe";
            process.StartInfo.Arguments = $"{filePath} -Tjpg -O";

            return process;
        }

        public static void Execute(Graph graph, string filepath)
        {
            using (var sw = File.CreateText(filepath))
            {
                sw.Write(graph.Content);
            }

            var process = BuildProcess(filepath);

            process.Start();
            process.WaitForExit();
        }
    }
}
