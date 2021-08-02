lexer grammar RelationLexer;

NEWLINE        : ('\r\n' | '\r' | '\n');
WS          : [\t ]+ -> skip;
SEMI : ';';
CONJ        : '&&';
COMP        : '||';

LPARAN        : '(';

RPARAN        : ')';

VAR_NAME   : [A-Za-z0-9_]+ ;

DOT :  '.';

REFINES : '<=';
NOTREFINES : '</=';
LOCALCONSISTENCY: 'locally-consistent:';
NOTLOCALCONSISTENCY: 'not-locally-consistent:';