parser grammar RelationParser;
options { tokenVocab=RelationLexer; }

full : NEWLINE* facts EOF;

facts    : fact NEWLINE+ facts
        | fact NEWLINE*;


fact    : refinement | nonrefinement;

refinement : left=system REFINES right=system;
nonrefinement : left=system NOTREFINES right=system;

system    : system COMP system
        | conj_system;

conj_system : conj_system CONJ conj_system
            | term;

term    : COMPONENT
        | LPARAN system RPARAN;

