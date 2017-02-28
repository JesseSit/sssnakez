# sssnakez
Our testing methodology involves 3 methods. One to generate an array of a desired size populated with random integers from 0 to a desired upper bound, one to record the run time of the merge sort algorithm on a random array, and one to call the previous a certain number of times and average the runtimes out. By generating random arrays we are ensuring that we are not getting any special cases just by human selection. The importance of finding the average runtime is so that irregularities are ironed out over thousands of iterations. Such irregularities could be having a lack of computer resources during certain tests or starting up JDE. It is important to remember that the results of our tests vary computer to computer due to resources, so you may not have the same results, but the results should be fairly accurate relative to the system.
To test our algorithm of merge sort against a BigOh classification we used a method of approximating execution time. In this method we took the average runtime of sorting a single element list. This should be constant which would allow us to apply it to the BigOh classifications in order to get an approximate runtime on a specific computer(James’ computer in this case). If you click on the link at the bottom you will be able to view the tables. Notice how O(nlogn) came the closest to the actual outcomes. It is important to remember that BigOh is a measure of complexity, not runtime. This means that true runtime is a more complex function than nlog(n) that involves error, however the difference due to error should average out to 0 over an adequate number of tests. The difference between the BigOh and the true runtime could be shrunk even more if we extended our algorithm analysis beyond the leading term. Our results from testing confirmed our hypothesis that merge sort was O(nlogn) after figuring out that it splits the list in half which leads to log(n) and then we run through a loop n times which gives us nlogn.

Table data & 1st proof: https://docs.google.com/document/d/1lILfY4lx_79jLt3aA8igrNt5lVmWesSn8cCisKunBJk/pub

Point of confusion in correlation Graphs (2nd proof):

We plotted our calculated runtime values for each data set size against the expected runtime values for nlogn, n^2, and n. The calculate runtime values was the independent variable(x axis) while the expected runtime values were the dependent variable(y axis). We then calculated the lines of best fit for each graph. We looked for a graph with a slope closest to 1, since that would indicate a 1:1 correlation. A 1:1 correlation would mean that the actual run time is perfectly proportional to one of the expected run times. Based on the results of our first proof, we expected to have a 1:1 correlation to nlogn time but the slope was actually closer to 1 for n time. This was a point of confusion in our study. The graphs are below. 

actual runtime vs nlogn runtime:

![alt text](http://i66.tinypic.com/2a9dzz9.png "actual vs nlogn")

actual runtime vs n^2 runtime:

![alt text](http://i68.tinypic.com/2cpqr69.png "actual vs n^2")

actual runtime vs n runtime:

![alt text](http://i64.tinypic.com/2qbeoeo.png "actual vs n")
