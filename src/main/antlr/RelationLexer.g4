lexer grammar RelationLexer;

NEWLINE        : ('\r\n' | '\r' | '\n');
WS          : [\t ]+ -> skip;
SEMI : ';';
CONJ        : '&&';
COMP        : '||';

LPARAN        : '(';

RPARAN        : ')';

COMPONENT    : [A-Za-z0-9_]+[.][A-Za-z0-9_]+ ;

REFINES : '<=';
NOTREFINES : '</=';