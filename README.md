# Reservation-Service
Bootstrap Skaffold configuration
Run the following command to generate a skaffold.yaml config file:
skaffold init

### Use skaffold dev
Run the following command to begin using Skaffold for continuous development
skaffold dev

### Provide external IP
minikube tunnel

### Kafka
#### Create a topic and recovery
kubectl exec -it kafka-0 -- bash

#### Create a topic named reservation with three partitions and a replication factor of 3.
kafka-topics --create --topic reservation --partitions 2 --replication-factor 2 --bootstrap-server kafka-0.kafka-headless.kafka.svc.cluster.local:9092

#### Verify the topic partitions are replicated across all three brokers:
kafka-topics --describe --topic reservation --bootstrap-server kafka-0.kafka-headless.kafka.svc.cluster.local:9092

### Debugging With Skaffold


## EventStorming Proccess
### Schema

### Topic
1. reservation

### Unstructured Exploration
1. ReservationRequestedEvent
Triggered by the customer submitting a reservation request.
2. AvailabilityConfirmed
Emitted by the system after validating the request and confirming availability.
1. ReservationCreatedEvent
Signals that a new reservation has been successfully created.
2. ReservationCanceledEvent
Indicates that a reservation has been cancelled.
3. ReservationModifiedEvent
Notifies that changes have been made to an existing reservation.
4. ReservationCheckedInEvent
Signals that a booked service or resource usage has started.
5. ReservationCheckedOutEvent
Indicates that a booked service or resource usage has ended.
6. AddedToWaitlistEvent
Notifies that a customer has been added to a waitlist for a service/resource.
7. PromotionAppliedEvent
Signals the successful application of a promotion or discount to a reservation.
8. ReservationExpiredEvent
Signals that a reservation request has expired due to inactivity.
9. OverreservationProcessedEvent
Signals that the system has handled the situation of overreservation by managing excess reservations.
10. ReservationConfirmationSentEvent
Indicates that a confirmation notification has been sent to the customer after a successful reservation.
11. PaymentAuthorizedEvent (Policy Event Trigger)
Signals successful authorization of payment associated with a reservation.
12. PaymentCompletedEvent
Indicates the successful completion of a payment transaction for a reservation.
13. PaymentFailedEvent
Signals that a payment transaction for a reservation has failed.

### Timelines
Happy Path Workflow:
1. Reservation Creation
- Customer submits a reservation request.
- System validates the request and confirms availability.
- Reservation is successfully created.
- Confirmation is sent to the customer.
- Payment authorization is requested.
- Payment is successfully authorized.
- Payment completion is confirmed.
- Reservation is finalized.
2. Reservation Modification
- Customer requests a modification to an existing reservation.
- System validates the modification and confirms availability.
- Reservation is successfully updated.
- Confirmation of modification is sent to the customer.
- Payment authorization may be requested for additional charges.
- Payment, if required, is successfully authorized and completed.
- Updated reservation details are finalized.
3. Reservation Cancellation
- Customer requests cancellation of a reservation.
- System confirms cancellation.
- Reservation is successfully cancelled.
- Confirmation of cancellation is sent to the customer.
- Any applicable refunds are processed.
4. Check-In and Check-Out
- Customer checks in for a booked service/resource.
- System confirms check-in.
- Customer uses the service/resource.
- Customer checks out.
- System confirms check-out.


Alternative Path Workflow
1. Reservation Creation Failure
- Customer submits a reservation request.
- System validates the request but finds no availability.
- System notifies the customer of unavailability.
- Optionally, customer may be added to a waitlist.
2. Reservation Modification Failure
- Customer requests a modification to an existing reservation.
- System validates the modification but finds conflicts.
- System notifies the customer of the conflict and suggests alternatives.
3. Reservation Cancellation Failure
- Customer requests cancellation of a reservation.
- System encounters an error in cancellation.
- System notifies the customer of the failure and suggests contacting support.
4. Payment Failure
- Customer submits a reservation request.
- System validates the request and confirms availability.
- Payment authorization fails.
- System notifies the customer of the payment failure and suggests alternative payment methods.
5. Overreservation Handling
- Customer submits a reservation request.
- System validates the request and detects potential overreservation.
- System notifies the customer of the situation and suggests alternative reservation times or accommodations.

### Commands
1. CreateReservationCommand
Initiates the process of creating a new reservation.
2. SendReservationConfirmationCommand
Sends a confirmation notification to the customer after a successful reservation.
3. CancelReservationCommand
Requests the cancellation of an existing reservation.
4. ModifyReservationCommand
Initiates changes to an existing reservation, such as altering the time, duration, or details of the reservation.
5. CheckinCommand
Indicates the beginning of a booked service or resource usage.
6. CheckoutCommand
Indicates the end of a booked service or resource usage.
7. AddToWaitlistCommand
Adds a customer to a waitlist for a service/resource that is currently unavailable.
8. ApplyPromotionCommand
Applies a promotion or discount to a reservation.
9. ExpireReservationCommand
Marks a reservation request as expired due to inactivity or lack of confirmation.
10. ProcessOverreservationCommand
Handles the situation of overreservation by managing the excess reservations.


