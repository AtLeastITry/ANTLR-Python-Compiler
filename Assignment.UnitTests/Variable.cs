using Assignment.Implementation.Errors;
using Assignment.Services;
using System;
using Xunit;

namespace Assignment.UnitTests
{
    public class Variable
    {
        private string Clean(string expression)
        {
            return expression.Replace("\r", "").Replace("\n", "");
        }

        [Fact]
        public void DeclarationForInteger()
        {
            var tree = ASTService.CompileToAST("VARIABLE test as INTEGER;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.True("VARIABLE test" == result);
        }

        [Fact]
        public void DeclarationForDecimal()
        {
            var tree = ASTService.CompileToAST("VARIABLE test as DECIMAL;");
            var result = this.Clean(ASTService.CompileToPostFix(tree));
            Assert.True("VARIABLE test" == result);
        }

        [Fact]
        public void AssignmentForInteger()
        {
            var tree = ASTService.CompileToAST(@"
VARIABLE test as INTEGER;
test := 1;
");
            var result = ASTService.CompileToPostFix(tree);
            Assert.True("VARIABLE test\r\ntest 1 =\r\n" == result);
        }

        [Fact]
        public void AssignmentForDecimal()
        {
            var tree = ASTService.CompileToAST(@"
VARIABLE test as DECIMAL;
test := 1.5;
");
            var result = ASTService.CompileToPostFix(tree);
            Assert.True("VARIABLE test\r\ntest 1.5 =\r\n" == result);
        }

        [Fact]
        public void DuplicateDefinitionError()
        {
            bool hasError = true;
            try
            {
                var tree = ASTService.CompileToAST(@"
VARIABLE test as DECIMAL;
VARIABLE test as DECIMAL;
");
                var result = ASTService.CompileToPostFix(tree);
                hasError = false;
            }
            catch (DuplicateDefinitionException)
            {
                hasError = true;
            }
            catch (Exception e)
            {

            }

            Assert.True(hasError);
        }

        [Fact]
        public void TypeErrorForDecimal()
        {            
            bool hasError = true;
            try
            {
                var tree = ASTService.CompileToAST(@"
VARIABLE test as DECIMAL;
test := asd;
");
                var result = ASTService.CompileToPostFix(tree);
                hasError = false;
            }
            catch (IncorrectDataType)
            {
                hasError = true;
            }
            catch(Exception e)
            {

            }

            Assert.True(hasError);
        }

        [Fact]
        public void TypeErrorForInteger()
        {
            bool hasError = true;
            try
            {
                var tree = ASTService.CompileToAST(@"
VARIABLE test as INTEGER;
test := 1.5;
");
                var result = ASTService.CompileToPostFix(tree);
                hasError = false;
            }
            catch (IncorrectDataType)
            {
                hasError = true;
            }
            catch (Exception e)
            {

            }

            Assert.True(hasError);
        }
    }
}
