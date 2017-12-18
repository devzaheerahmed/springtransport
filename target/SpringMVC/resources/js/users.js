	
	 data = "";
    submit = function(){
    	var name= $('#name').val();
    	var pass= $('#password').val();
    	var emailvalidation =$('#email').val();
    	
    	
    	if (name !=="" && pass !=="" && emailvalidation !=="" ){
        
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{user_id:$("#user_id").val(),user_name:$('#name').val(),email:$('#email').val(),level:$('#level').val(),user_login:$('#userlogin').val(),password:$('#password').val()},
                success: function(response){
                        alert(response.message);
                        load(0,0);    
                },error:function(xhr){
                	alert("user-Login Or email already exit");
                }
               
            });        
    
    	}
    }
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{user_id:id},
            success: function(response){
                    alert(response.message);
                    load(0,0);
            }              
        });
	}
     
 
    edit = function (index){
        $("#user_id").val(data[index].user_id);
        $("#name").val(data[index].user_name);
        $("#email").val(data[index].email);
        $("#level").val(data[index].level).attr('selected','selected');
        $("#password").val(data[index].password);
        $("#userlogin").val(data[index].user_login);
       
         
    }
     
      
     var firstresult=0;
     var numbersofresult=0;
     var currentresponsedatalength=0;
     var pagetypevalue;
     load = function(pagetype,x){     	
    		var pagetype=pagetype.toString();
    	if(x ==='undefined'){x=0;console.log("undefined " +x);}
    	if(pagetype.indexOf("prev")>=0) {pagetypevalue=pagetype; alert("prev " +x);this.firstresult=firstresult-x; }
    	if(pagetype.indexOf("next")>=0) { pagetypevalue=pagetype; alert("next " +x);this.firstresult=firstresult+x; }
    	if(firstresult<=0){$("#prevpage").hide();}
    	//this.firstresult=firstresult+x;
    	console.log("firstresult " +firstresult);
    	$.ajax({
            url:'list',
            type:'POST',
            data: {firstresult : firstresult},
            success: function(response){
                data = response.data;
                console.log("response.data.length" +response.data.length) ;
                currentresponsedatalength=response.data.length;
                    $('.tr').remove();
                   for(i=0; i<response.data.length; i++){ 
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].user_name+" </td> <td> "+response.data[i].email+" </td> <td> "+response.data[i].level+" </td> <td> "+response.data[i].user_login+" </td> <td>  <input type='password'value= "+response.data[i].password+" >  </td>  <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
                    }       
            }    
        });
     }
    
    var currentpage=1;
    var pagesize=0;
     nextpage= function(x){
     console.log("pagesize "+x);
	 currentpage=currentpage+1;
  	 console.log("currentpage " + currentpage);
  	 pagesize=x;
  	$.ajax({
        url:'resultcount',
        type:'POST',
        success: function(response){
        	data = response.data;
        	var totalnumberofpages =  Math.ceil(response.data.length / pagesize);
        	var lastPageNumber =  Math.ceil(response.data.length /pagesize);
        	console.log("lastPageNumber" + lastPageNumber);
        	if(currentpage >=lastPageNumber){
        		 $("#nextpage").hide();
        	}
        	
        	if(currentpage <=lastPageNumber){
       		 $("#prevpage").show();
       	}
            console.log(response.data.length)
            $("#total").html("<div> "+currentpage+" &nbsp; outOf  &nbsp;"+totalnumberofpages+"  &nbsp; pages</div>");
           // $("#table").append("<tr class='tr'> <td>  "+response.data.length+" </td>  <td> <div class='nextdiv' id='nextdiv' style='display:"+nextdisplay+"' > <a href='#' onclick= nextpage("+pagesize+");> Next </a>  </div></td></tr>");
            load("next",15);
        }    
  	
    });
     }
  	
     prevpage= function(x){
         console.log("pagesize "+x);
    	 currentpage=currentpage-1;
      	 console.log("currentpage " + currentpage);
      	 pagesize=x;
      	  
      	$.ajax({
            url:'resultcount',
            type:'POST',
            success: function(response){
            	data = response.data;
            	var totalnumberofpages =  Math.ceil(response.data.length / pagesize);
            	var lastPageNumber =  Math.ceil(response.data.length / pagesize);
            	console.log("lastPageNumber" + lastPageNumber);
            	if(currentpage<=1){
            		
            		 $("#prevpage").hide();
            		
            	}
            	
            	if(currentpage>=1){
            		
            		 $("#nextpage").show();
            		
            	}
            	
            	
                console.log(response.data.length)
                $("#total").html("<div> "+currentpage+" &nbsp; outOf  &nbsp;"+totalnumberofpages+"  &nbsp; pages</div>");
               // $("#table").append("<tr class='tr'> <td>  "+response.data.length+" </td>  <td> <div class='nextdiv' id='nextdiv' style='display:"+nextdisplay+"' > <a href='#' onclick= nextpage("+pagesize+");> Next </a>  </div></td></tr>");
                load("prev",15);
            }    
      	
        });
         }
    	
    
    

