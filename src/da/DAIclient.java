package da;

import java.util.List;

import model.client;

public interface DAIclient {

	public void addClient (client client);
	public List <client> getAllClient();
	public client getClientById (int clientid);
	public void delete (int clientid);
	public void update (client client);
}
