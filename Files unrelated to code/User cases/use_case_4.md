# USE CASE: 4 Compute data

## CHARACTERISTIC INFORMATION

### Goal in Context

Being a -Manager- I want -percentages as well as numbers- so that -I can both understand and view the data-.

### Scope

Compute data to provide percentages where needed

### Level

Primary task

### Preconditions

Data is available in a database we are able to access within code.

### Success End Condition

We are able to provide percentages for certain data

### Failed End Condition

Percentages are inaccurate for cartain data

### Primary Actor

Manager

### Trigger

Manager is requested with a percentage of some data

## MAIN SUCCESS SCENARIO

1. Manager is requested with a percentage of some data
2. Manager runs application
3. Manager chooses right options
4. Manager gives data
5. Information is sufficient for who requested it

## EXTENSIONS

2. **Unable to run application**:
    1. We have provided indications related to requirements for running the application.
3. **Wrong criteria provided to the application**:
    1. Manager is able to restart or re-enter the data without problems.
3. **Cannot find option that gives percentages**:
    1. We have to add the word 'percentage' where we offer them, and make sure taht we explain the output of every option
5. **Requested data was insufficient**:
    1. Manager is able to provide additional data without editing the application output much or at all.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

