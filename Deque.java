package algoritmos;

public class Deque {
	int size;
	char head;
	int head1;
	char tail;
	int tail1;
	char [] arr;
	
	public Deque(){
		size=0;
		head='\0';
		head1=0;
		tail='\0';
		tail1=0;
		arr = new char[1];
	}
	int size(){
		return size;
	}
	char front(){
		return head;
	}
	char back(){
		return tail;
	}
	void addFront(char x){
		if(size==0){
	         arr[0]=x;
				head=tail=arr[0];
			}
		else if (size==arr.length){
			ResizeFront();
			arr[0]=x;
			head=arr[0];
			head1=0;
			}
		else if(head1==0){
			ResizeFront();
			arr[0]=x;
			head=arr[0];
			head1=0;
			
		}
		else if (head1<arr.length && head1>0){
			char prov[]=new char[size+1];
			int j=1;
			int i = head1;
			while( i<=size){
				prov[j]=arr[i];
				j++;
				i++;
				
			}
			i=0;
			while(i<=tail1){
				prov[j]=arr[i];
				i++;
				j++;
			}
			prov[0]=x;
			arr=prov;
			head=x;
			head1=0;
		}
		
		size++;
	}
	void enqueue(char x){
		if(size==0){
         arr[0]=x;
			head=tail=arr[0];
		}
		else if (size==arr.length){
			ResizeArr();
			arr[size]=x;
			tail=arr[size];
			tail1=size;
			}
		else if(tail==arr[arr.length-1]){
			arr[0]=x;
			tail=arr[0];
			tail1=0;
			}
      else if(arr[0]=='\0'){
         for(int con=1;con<arr.length;con++){
            if(arr[con-1]==tail){
               arr[con]=x;
               tail=arr[con];
               tail1=con;
               break;
            }
         }
      }
      else{
			for(int con=0; con<=size;con++){
				if(arr[con]=='\0'){
					arr[con]=x;
					tail=arr[con];
					tail1=con;
					break;
				}
			}
			    
		}	
				
		
		size++;
	}
	
	char dequeue() throws Exception{
		if (size==0)
			throw new Exception();
		char ret=head;
		if(head==arr[arr.length-1]){
			head=arr[0];
		    arr[arr.length-1]='\0';
		    }
		else{ 
			for(int con=0; con<size;con++){
			if(arr[con]==head){
				head=arr[con+1];
				arr[con]='\0';
				head1=con+1;
				break;
			}
		}
			}
		size--;
		return ret;
	}
	  void ResizeArr(){
			char temp[]=new char [size*2];
         int size_2=0;
         int i=0;
        if(head!=arr[0]){
        for (i=0;i<arr.length;i++){
           if(arr[i]==head ){
              temp[size_2]=arr[i];
               size_2++;
               break;
               
           }
           
        }i++;
           while(i<arr.length){
              temp[size_2]=arr[i];
              i++;
              size_2++;
           }
           for(int j=0;arr[j]!=tail;j++){
              temp[size_2]=arr[j];
              size_2++;
           }
           temp[size_2]=tail;
           tail=temp[size_2];
           tail1=size_2;
        }
        else{
        for(int k=0;k<size;k++)
           temp[k]=arr[k];
        }
			arr=temp;
		}
	  void ResizeFront(){
		  char temp[]=new char [size*2];
	         int size_2=0;
	         int i=1;
	        if(head!=arr[0]){
	        for (i=1;i<arr.length;i++){
	           if(arr[i]==head ){
	              temp[size_2]=arr[i];
	               size_2++;
	               break;
	               
	           }
	           
	        }i++;
	           while(i<arr.length){
	              temp[size_2]=arr[i];
	              i++;
	              size_2++;
	           }
	           for(int j=0;arr[j]!=tail;j++){
	              temp[size_2]=arr[j];
	              size_2++;
	           }
	           temp[size_2]=tail;
	           tail=temp[size_2];
	           tail1=size_2;
	        }
	        else{
	        	int z=1;
	        for(int k=1;k<size;k++)
	           temp[k]=arr[z];
	           z++;
	        }
				arr=temp;
			} 
	  public static void main(String[] args){
		  Deque q=new Deque();
		  q.enqueue('a');
		  q.enqueue('b');
		  //q.enqueue('c');
		  //q.enqueue('d');
		  q.enqueue('e');
		  try{
			  q.dequeue();
			  q.dequeue();
			  }catch(Exception e){}
		  q.enqueue('ñ');
		  q.enqueue('p');
        q.addFront('h');
        q.enqueue('r');
		  
	  }
	
	  
}
		


