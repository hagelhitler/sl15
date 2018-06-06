import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.rmi.server.*;
public class Servant extends UnicastRemoteObject implements ServerInterface  
{
	public Servant()throws RemoteException
	{
		super();
    	}
	public String concat(String a,String b) throws RemoteException
	{
		return a+b;
	}
}

