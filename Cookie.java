java.sql.Time
/**
	A data structure to hold cookie efficiently.
**/
public class Cookie{
	private class Tuple{
		private String value;
		private TIME time;
		public Tuple(){}
		public Tuple(String value , TIME time){
			this.value = value;
			this.time = time;
		}
		public String getValue(){
			return value;
		}
		public TIME getTime(){
			return time;
		}
	}
	HashMap<Integer, Tuple> cookie = new HashMap<Integer, Tuple>();
	public Cookie(){}
	public Cookie(int key, String value, TIME time){
		setCookie(key,value,time);
	}
	public void setCookie(int key, String value, TIME time){
		Tuple timeValuePair = new Tuple(value, time);
		cookie.put(key, timeValuePair);
	}
	/* Added synchronized to this method because getValueByKey() can be accessed by many clients at the same 
		time in which one may delete the key, value where other is try to return. It will reduce it efficiency*/
	public synchronized String getValueByKey(int key){
		Tuple temp = new Temp();
		temp = cookie.get(key);
		if(temp.time < System.CurrentTimeInMilles){
			removeCookie(key);
			return "";
		}
		return cookie.value;
	}
	private void removeCookie(int key){
		cookie.remove(key);
	}
	
	// Tester Main function to test the functionality
	public static void main (Strings[] args){
		Cookie test = new Cookie();
		test.setCookie(10, "Tempo", System.CurrentTimeInMilles +1);
		System.out.println(test.getValueByKey(10));
	}
}