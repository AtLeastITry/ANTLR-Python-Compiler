using Assignment.Services;
using Xunit;

namespace Assignment.UnitTests
{
    public class Arthimetic
    {
        private string Clean(string expression)
        {
            return expression.Replace("\r", "").Replace("\n", "");
        }

        [Fact]
        public void Addition()
        {
            var tree = ASTService.CompileToAST("1 + 1;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.Equal("1 1 +", result);
        }

        [Fact]
        public void Subtraction()
        {
            var tree = ASTService.CompileToAST("1 - 1;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.Equal("1 1 -", result);
        }

        [Fact]
        public void Multiplication()
        {
            var tree = ASTService.CompileToAST("1 * 1;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.Equal("1 1 *", result);
        }

        [Fact]
        public void Division()
        {
            var tree = ASTService.CompileToAST("1 / 1;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.Equal("1 1 /", result);
        }

        [Fact]
        public void Parenthese()
        {
            var tree = ASTService.CompileToAST("(2 + 1) * (3 + 4);");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.Equal("2 1 + 3 4 + *", result);
        }

        [Fact]
        public void Complex()
        {
            var tree = ASTService.CompileToAST("1 + 2 * 3 + 4;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.Equal("1 2 3 * + 4 +", result);
        }
    }
}
