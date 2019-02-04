grammar Language;

compileUnit
    :   expr (EndOfLine expr)* EOF
    ;

expr
    :   LPARA expr RPARA                      # parensExpr
    |   op=(PLUS|MINUS) expr                  # unaryExpr
    |   left=expr op=(MULT|DIV) right=expr    # infixExpr
    |   left=expr op=(PLUS|MINUS) right=expr  # infixExpr
	|   variable=VAR op=AssignOP right=expr   # assignmentExpr 
    |   func=ID LPARA expr RPARA              # funcExpr             
	|	VARIABLEKEYWORD name=VAR 'as' type=(INTERGER|STRING)			  # variableDeclarationExpr
	|   value=(NUM|VAR)                       # valueExpr
	;
NUM :   [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
LPARA   : '(' ;
RPARA   : ')' ;
AssignOP : ':=' ; 
EndOfLine: ';';
VAR     : ('a'..'z')+ ;
INTERGER: 'INTEGER';
STRING: 'STRING';
VARIABLEKEYWORD : 'VARIABLE';
WS  :   [ \t\r\n] -> channel(HIDDEN);

