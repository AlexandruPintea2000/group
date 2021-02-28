# USE CASE: 7 Multiple data output layouts

## CHARACTERISTIC INFORMATION

### Goal in Context

Being a -Manager- I want -flexible data organisation- so that -I can explain it to others in multiple ways until they understand-.

### Scope

Provide multiple ways of viewing the data, related to how much details about the data is needed.

### Level

Primary task

### Preconditions

We implement output layouts as we compute the outputted data.

### Success End Condition

Data is available in multiple layouts

### Failed End Condition

Data not fully available in certain layouts

### Primary Actor

Manager

### Trigger

Manager wants to show the almost the same data in another way

## MAIN SUCCESS SCENARIO

1. Manager wants to show the almost the same data in another way
2. Manager runs the application with right options at least twice
3. At last, a layout is found that helps the others understand the data

## EXTENSIONS

2. **Unable to run application**:
    1. We have provided indications related to requirements for running the application.
2. **Wrong criteria provided to the application**:
    1. Manager is able to restart or re-enter the data without problems.
3. **Requested data was insufficient**:
    1. Manager is able to provide additional data without editing the application output much or at all.
3. **The others still do not understand teh data**:
    1. We provided data conversion information, so that the Manager is able to edit the data in any way.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

