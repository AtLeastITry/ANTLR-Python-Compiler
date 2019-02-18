grammar Language;

compileUnit
    :   expr (EndOfLine expr)* EOF
    ;

identifier
	: Identifier
	| 'INTEGER'
	| 'DECIMAL'
  ;

expr
    :   LPARA expr RPARA                      # parensExpr
	|	type=(INTERGER|DECIMAL) name=VAR      # variableDeclarationExpr
    |   op=(PLUS|MINUS) expr                  # unaryExpr
	|	left=expr op=POWER right=expr         # infixExpr
    |   left=expr op=(MULT|DIV) right=expr    # infixExpr
	|   left=expr op=(PLUS|MINUS) right=expr  # infixExpr
	|   variable=VAR op=AssignOP right=expr   # assignmentExpr 
    |   func=ID LPARA expr RPARA              # funcExpr             	
	|   value=(NUM|VAR)                       # valueExpr
	;

NUM :   [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
POWER     : '^' ;
LPARA   : '(' ;
RPARA   : ')' ;
AssignOP : '=' ; 
EndOfLine: ';';
VAR     : ('a'..'z')+ ;
INTERGER: 'INTEGER';
DECIMAL: 'DECIMAL';
WS  :   [ \t\r\n] -> channel(HIDDEN);

