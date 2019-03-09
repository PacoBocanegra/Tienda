import redis.clients.jedis.Jedis;

public class DAOImpCompraRedis implements DAOCompra {
	private Jedis jedis;
        public DAOImpAulaRedis() {
	  jedis = new Jedis("192.168.121.161");
	  jedis.select(3);
	}
	public void grabar(Compra a){
		String datos = "";
		datos += a.getPer().getName() + ":";
        datos += a.getPro().getNombre() + ":";
        datos += a.getPro().getMarca() + ":";
        datos += a.getCant() + ":";
        datos += a.getPro().getPrecio() + ":";
        jedis.rpush("lalistadecompras",datos);
    }
}
