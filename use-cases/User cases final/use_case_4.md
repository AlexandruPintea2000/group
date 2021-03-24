# USE CASE: 4 Language data

## CHARACTERISTIC INFORMATION

### Goal in Context

Being a -Marketer- I want -statistics realted to spoken languages- so that -I am able to decide what languages to consider the most when marketing-.

### Scope

Provide language related data both in general ( for any language ) and in particular ( for the languages specified ).

### Level

Primary task

### Preconditions

Data is available in a database we are able to access within code.

### Success End Condition

We are able to provide language data for any language

### Failed End Condition

We are not able to provide language data for any language

### Primary Actor

Marketer

### Trigger

Marketer is requested with a language data

## MAIN SUCCESS SCENARIO

1. Marketer is requested with a percentage of some data
2. Marketer runs application
3. Marketer chooses option "Population by spoken language"
4. Marketer chooses any of the options "1. Provide languages  2. Use predefined languages ( Chinese, English, Hindi, Spanish and Arabic )"
5. Marketer gives data
6. Information is sufficient for who requested it

## EXTENSIONS

2. **Unable to run application**:
    1. We have provided indications related to requirements for running the application.
4. **Wrong criteria provided to the application**:
    1. Marketer is able to restart or re-enter the data without problems.
6. **Requested data was insufficient**:
    1. Marketer is able to provide additional data without editing the application output much or at all.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

