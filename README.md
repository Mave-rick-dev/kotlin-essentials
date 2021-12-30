
Fundamental differences between threads vs coroutines

1. When introducing a coroutine, the tasks assigned to it started immediately for which it is executed on a seperate thread other than 
the thread that initiated it.
https://github.com/Mave-rick-dev/kotlin-essentials
2. To note, they does not executes simultaneously (concurrently); in parallel 
	i.e. the main thread even after its completion does not waits for the coroutine
	 to complete its task, i.e. the app stops aftaer the main thread stops.

3. However, in case of threads they run in parallel (concurrently) i.e. the main thread
	waits for the background thread. The app stops only after the completion of all tasks of both threads.

4. The thread needs to sleep for duration equivalent to the duration required by the coroutine to compelete its task.

5. delay(millis) vs sleep(millis)

- delay() is offered by kotlinx.coroutines and unlike sleep(), it does not block the thread, but suspends (pauses) only the coroutine i.e. other coroutines that may be running on the same thread can execute without having to wait for the suspended thread. 
	Note: delay() is a suspend function, so the uncertanity of the thread-choice after suspend (due to delay() or any other suspend function) still persists.

- sleep() is offered by Java.lang and compeletely blocks the current thread i.e. the thread cannot be utilized for other tasks


6. Suspending function( 'suspend' modifier)
- Can only be called from a coroutine or another suspending function
- To call it from a thread or outside the cooroutine, delay() or any other suspend function need to be wraped inside another suspend function.


7. runBlocking() vs GlobalScope.launch
	runBlocking():
		- creates a new coroutine, suitable for wraping delay()
		- blocks the current thead (that initiates the runBlocking) duration of its execution 

	GlobalScope.launch:
		- creates a new coroutine, that does not blocks the current 
		thread

8. Renouned Coroutines builders: launch, async, and runBlocking

	- launch (Fire and Forget)
		- creates a new coroutine of non-blocking nature and returns a Job

		-  coroutines from launch inherits the scope of its immediate coroutine i.e. runs on the same thread as its parent coroutine.
		So if a coroutine C1 starts on Thread-1 which has another coroutine C2 (via launch{} fun), C2 will run on the same Thread T1 as C1.

		- often seen with GlobalScope(companion object; delicate api) as GlobalScope.launch{}, however use of GlobalScope is usually discouraged as such coroutines when untracked can consume unecessary memory and cpu usage.

		- offers join() and close() as suspend function that suspends the coroutine


	- async 
		- creates a new coroutine of non-blocking nature and returns a Deferred<T> object

		- coroutines from async inherits the scope of its immediate coroutine i.e. runs on the same thread as its parent coroutine.

		- the deferred job offers await() to acquire the return type, and join() and close() to wait or close the coroutine

	- runBlocking
		-Runs a new coroutine and blocks the current thread interruptibly until its completion. 

		- This function should not be used from a coroutine. It is designed to bridge regular blocking code to libraries that are written in suspending style, to be used in main functions and in tests.

		- mostly used to test the suspending functions as when calling the function from the test class, the class must be a coroutine or a suspending function itself. For this, we make the class return a runBlocking (a coroutine) and now we can call the function we want to test.

9. Coroutine cancellation: Making coroutine cooperative
	- Two ways to cancel coroutine:
		1. use of suspending function offered by kotlinx.coroutines
		2. use of boolean flag: isActive 

10. Cooperative coroutines implements suspending function and can be cancelled by the dependent coroutine, otherwise it fails i.e. program flow continues without interruption.
	
	- If coroutine C1 (parent) want to cancel coroutine C2 (child) as it is taking too much time, C2 must implement a suspending function to qualify as cooperative function. If not, C1 running asynchronously to C2 will wait till C1's completion without interuption.

	- NOTE: if C2 and C1 is running on the same background thread, C2 gets cancelled regardless it has implemented kotlinx suspending function or not.

11. Breaking a coroutine with 'return@coroutineBuilder' will not execute the code futher below, hence equivalent to using 'break'

12. Coroutine exception handling:
	- all cancellable suspending functions (yield(), delay(), withTimeout(), withContext(), etc.) throws CancellationException on coroutine cancellation

	- It can be caught within try...catch block when parent coroutine invokes the cancel() 

	- We cannot call a suspending fun from the try...catch catching the CancellationExeception as the coroutine/job we are trying to handle is already cancelled, but in case we want to call a suspending function inside finally block, try...catch must be wrapped inside withContext(NonCancellable)

	?? withContext(NonCancellable) vs runBlocking in case for calling suspending fun from finally block 

	- withTimeout(millis: Long) throws TimeoutCancellationException when the coroutine job exceeds the time specified in millis. However, withTimeoutOrNull(millis: Long) does not throws the  TimeoutCancellationException in any case.

	- withTimeoutOrNull(millis: Long)
		- returns an object after the completion of the block within it
		- NOTE: if the block is taking too long, or if its completion time is below the millis defined in withTimeoutOrNull, the return type is initialized as null; we will not get the defined return value 


13. Coroutine scope
	- Each coroutine(s) whether parent-child or not, has its own scope idetifiable from the hexacode obtained from $this (return the object describing the scope of the coroutine running it)

	- @this return the scope object of the immeditate coroutine

14. coroutineContext
	- attribute of immediate coroutine that defines its dispatcher, job and name

	Case-I:
	lauch(Dispatchers.Default){ //PC1
			//some task
		lauch(coroutineContext){ //C1
			//some task 1
			delay(3000)
			//some other task 2
		}
	}
	Case-II:
	fun main() = runBlocking { //PC2
			//some task
		lauch(coroutineContext){ //C2
			//some task
			delay(3000)
			//some other task
		}
	}
	- Here, C1 inherits context of PC1 and C2 from PC2, hence C1's may be dispatched to some other thread for task-2 after its suspension for 3sec (app-level thread).
	- Similarly, 

	Q:
	 After blocking the thread, if the coroutine (blocker) is delayed , will the remaining task of the coroutine be assigned to some other thread?
		Ans: No, since the lauch inherits the context (thread) of its parent (nonBlocking), it will execute on the same thread till its completion


15. Coroutine context
	- CoroutineContext = Job + Dispatcher (Decides which thread to assign the coroutine) + coroutineName
	- Some coroutine contexts:
		- Unconfined
		- Confined (unparameterized)
		- Default
		- using coroutineContext attribute as p
