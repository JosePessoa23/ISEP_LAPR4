grammar SurveyGrammar;
prog: survey;

survey: surveyID NEWLINE title NEWLINE welcomeMessage sectionList finalMessage # questionario;

surveyID:   alphanumeric ;

alphanumeric:   LETTER alphanumeric
                | NUMBER alphanumeric
                | LETTER
                | NUMBER
                ;

title:  sentence ;

welcomeMessage: sentence* NEWLINE ;

sentence:   LETTER+ SPACE? sentence
            | NUMBER+ SPACE? sentence
            | END+ SPACE? sentence
            | END+
            ;

sectionList: section+ ;

finalMessage: sentence* NEWLINE ;

section: sectionID END? SPACE title NEWLINE shortDescription obligatoriness NEWLINE content # seccao;

sectionID: NUMBER+ ;

shortDescription: sentence* NEWLINE ;

obligatoriness: MANDATORY
                | OPTIONAL
                | CONDITION_DEPENDENT condition
                ;

condition:  SPACE sectionID SPACE questionID SPACE choiceID ;

content: question+ ;

question: questionID END? SPACE questionSentence type NEWLINE obligatoriness NEWLINE # questao;

questionID: NUMBER+ ;

questionSentence:   sentence+ NEWLINE ;


type:   FREE_TEXT
        | NUMERIC
        | SINGLE_CHOICE1 choices
        | SINGLE_CHOICE2 choices
        | MULTIPLE_CHOICE1 choices
        | MULTIPLE_CHOICE2 choices
        | SORTING_OPTIONS choices
        | SCALLING_OPTIONS choices
        ;

choices:    choice+ ;

choice: NEWLINE choiceID CHOICEMARK SPACE sentence ;

choiceID: LETTER+ ;

//TOKENS
NEWLINE : [\r\n]+ ;
NUMBER : [0-9] ;
LETTER : [A-Za-z] ;
SPACE : ' ' ;
END : [-.;:?!] ;
MANDATORY : 'mandatory' ;
OPTIONAL : 'optional' ;
CONDITION_DEPENDENT : 'condition dependent' ;
FREE_TEXT : 'free-text' ;
NUMERIC : 'numeric' ;
SINGLE_CHOICE1 : 'single-choice' ;
SINGLE_CHOICE2 : 'single-choice with input value' ;
MULTIPLE_CHOICE1 : 'multiple-choice' ;
MULTIPLE_CHOICE2 : 'multiple-choice with input value' ;
SORTING_OPTIONS : 'sorting options' ;
SCALLING_OPTIONS : 'scalling options' ;
CHOICEMARK : [).] ;