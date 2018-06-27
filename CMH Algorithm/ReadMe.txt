Another fully distributed deadlock detection algorithm is given by Chandy, Misra, and Hass (1983).
This is considered an edge-chasing, probe-based algorithm.
It is also considered one of the best deadlock detection algorithms for distributed systems.
If a process makes a request for a resource which fails or times out,
    the process generates a probe message and sends it to each of the processes holding one or more of its requested resources.
Each probe message contains the following information:
the id of the process that is blocked (the one that initiates the probe message);
the id of the process is sending this particular version of the probe message; and
the id of the process that should receive this probe message.
When a process receives a probe message,
    it checks to see if it is also waiting for resources.
If not, it is currently using the needed resource
    and will eventually finish and release the resource.
If it is waiting for resources, it passes on the probe message to all processes it knows to be holding resources it has itself requested.
The process first modifies the probe message, changing the sender and receiver ids.
If a process receives a probe message that it recognizes as having initiated,
    it knows there is a cycle in the system
    and thus, deadlock.