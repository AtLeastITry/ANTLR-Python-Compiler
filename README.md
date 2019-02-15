# CE305 Assignment One Expression Analyser

## Introduction

This assignment requires you to build an expression analyser which compiles arithmetic expressions into a form that can be evaluated by a stack-based interpreter, together with documentation. 

You are also required to produce and present details of the formal specification of the expression analyser. The parser should have options to display the internal representation of parsed expressions in an easily readable form (e.g. using graphviz or similar- if you are using Antlr it does show the parse tree). The final program should produce sensible error messages if given ill-formed expressions. 
1. You need to submit the Specification and Implementation electronically by the published deadline. 
2. You need to demonstrate the implementation in the lab, (date 19-Feb)

## The Specification

You are expected to provide a specification of the languages and translations that are involved in your expression compiler. These should include: 
1. the tokens of the source (and target) language; 
2. the syntax of the expressions of the source language; 
3. the syntax of the target language; 4. a declarative description of the translation.

If you extend the system to deal with floating point values, then these should also be described. 

## The Tokens
Formulate regular expressions that define what tokens are recognised. These should be structured definitions. The top level should be the regular expression that matches any token. The next level should be the names of the main token types.. 

## The Expressions
You should state the syntax of the expressions that your system recognises (the source expressions) using BNF or EBNF notation. The formulation should be expressed in terms of the tokens you have defined. 

## The Target Language
Provide a formalisation of the target language in (E)BNF. 

## The Translation
Give a declarative description of how the source language is to be translated in the target language. 
This should be a recursive definition stated mathematically, or in clear English. 

## The Implementation
 
You can try using libraries, such as java.util.regex, and ANTLR. In the latter case, you will be expected to select and learn about the tools by yourself. Your report should then contain a description of how the tools were applied. 

Hand-coded systems will be assessed for coding quality. Systems produced using tools will be assessed for the effectiveness with which those tools were used. 

## Extended features
Some marks will be awarded for program features. Features include 
1. visual rendering of the parse tree. 
2. support for floating-point expressions as well as integers. 
3. helpful and informative errors messages, 
You are expected to attempt at least one such feature. 

## Modularity
Program code will be assessed for its modularity. A clear separation of the different aspects of the system (tokenisation, parsing) is expected.

## Documentation 
Your program code should be documented.

## The Submission and Demonstration 

### Demonstration 
Week 19-Feb 2019 Lab session 

### Submission Deadline 
Week 26 Feb 2019 

### The Submission 
The electronic submission should include the specification and the documented implementation. The documentation for the implementation can be included as a section in the report, as clear and detailed comments in the program source files, or as a separate document. 
 
### The Demonstration 
(TBC) You will be expected to demonstrate your program(s) in the lab session following the submission (date 19-Feb). 

## Draft Marking Scheme 
Scheme provided for indicative guidance only 

### Specification (40%)   
- Definition of Tokens 10 
- Grammar of Expressions 15 
- Description of Translation 15 
### Implementation (50%)
- Basic operation 20
- Modularity 10
- Coding quality and/or use of tools 10
- Extended features 10 
### Other (10%)
- Clarity of report [and documentation] 10%

## Extensions leading to the second assignment
You may wish to start extending your expression analyser ready for the second assignment.
- Add support for variables, and assignment statements that assign values to those variables. 
- Add control flow for multiple statements, with Boolean expressions. 