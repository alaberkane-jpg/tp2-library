
# UC-07 – Register a return

## Name
UC-07 Register a return

## Goal
Register the return of a borrowed copy, close the corresponding loan, and update the copy's status.

## Actors
- Primary actor: Librarian.
- Stakeholder: Member.
- Supporting system: Library system.

## Level and scope
User goal; Library system.

## Preconditions
- The librarian is authenticated.
- The member has a copy to return.
- The copy has an open loan in the system.

## Trigger
A member brings a borrowed copy back to the library.

## Main success scenario
1. The member gives the borrowed copy to the librarian.
2. The librarian identifies the returned copy.
3. The system finds the corresponding open loan.
4. The system checks the return date against the loan's due date.
5. The system closes the loan by recording the return date.
6. The system checks whether the book is reserved by another member.
7. If the book is not reserved, the system marks the copy as available.
8. The librarian ends the transaction.

## Alternative flows
**6a. The book is reserved by another member:**
1. The system keeps the returned copy aside.
2. The system identifies the member who reserved the book.
3. The system sends a notification to that member.
4. The use case continues at step 8.

## Exceptions
None explicitly specified in the TP instructions.

## Postconditions
**Success:**
- The loan is closed.
- The return date is recorded.
- The copy is either available or kept aside for the member who reserved it.
- The reserved member is notified when applicable.

## Special requirements
- The system must correctly detect late returns.
- The system must correctly update the copy's status.
- The system must notify the member who reserved the returned book.

## Open issues
- What notification method is used (email or another method)?
- How long is a reserved copy kept aside?
- What happens if the returned copy is damaged?
