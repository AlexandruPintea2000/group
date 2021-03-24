# USE CASE: 1 Primary data sorting features

## CHARACTERISTIC INFORMATION

### Goal in Context

Being a -HR advisor- I want -the ability to sort data based on population- so that -I am able to provide details for every entry, in the order that they matter-.

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the role. Database contains add data we might need. We know how to sign into the database and have database users to make the data safe. Sorting is available using the database language.

### Success End Condition

All primary sorting features are functional.

### Failed End Condition

Any sorting function fails in most cases.

### Primary Actor

HR advisor

### Trigger

The advisor is asked about certain population related data that has to be sorted when provided.

## MAIN SUCCESS SCENARIO

1. HR advisor recieves data request
2. HR advisor runs the application using the criteria provided by the request
3. HR advisor gets to the "Largest to Smallest" option
4. HR advisor gets to the "1. Country  2. City  3. Capital City" options
5. HR advisor chooses option requested for requested data, gets and sends data
6. Whoever requested data is satisfied with what they got

## EXTENSIONS

2. **Unable to run application**:
    1. We have provided indications related to requirements for running the application.
2. **Wrong criteria provided to the application**:
    1. HR advisor is able to restart or re-enter the data without problems.
6. **Requested data was insufficient**:
    1. HR advisor is able to provide additional data without editing the application output much or at all.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

