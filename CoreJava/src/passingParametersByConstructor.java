
public class passingParametersByConstructor extends SuperClass {


		
		int a;
		public passingParametersByConstructor(int a) {
			// TODO Auto-generated constructor stub
			super(a);
			this.a=a;
		}
		public int increament() {
			 a=a+1;
			// System.out.println(a);
			return a;
		}
		public int decreament() {
			 a=a-1;
			 //System.out.println(a);
			return a;
		}

	}


