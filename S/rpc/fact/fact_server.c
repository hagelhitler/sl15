/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "fact.h"

int *
fact_1_svc(intpair *argp, struct svc_req *rqstp)
{
	static int  result,n,fact;
	int i;

	n=argp->a;
	fact=1;
	printf("\n Received n=%d",n);
	for(i=n;i>0;i--)
	{
		fact=fact*i;
	}
	result=fact;
	return &result;
}
