<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
  </head>
  <body>
    <button id="authorize_button" >인증 후 캘린더 저장</button>
    <button id="signout_button" >로그아웃 및 종료</button>      
    <pre id="content" style="white-space: pre-wrap;"></pre>   
   <script type="text/javascript">
      // Client ID and API key from the Developer Console
      var CLIENT_ID = '369871392266-r7d5vs18ahla28o3bmaqbammbvm5afec.apps.googleusercontent.com';
      var API_KEY = 'AIzaSyBy3xFAJvM6AtSWg4SgqN0V2m1h_iXxV_0';

      // Array of API discovery doc URLs for APIs used by the quickstart
      var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];

      // Authorization scopes required by the API; multiple scopes can be
      // included, separated by spaces.
      var SCOPES = "https://www.googleapis.com/auth/calendar";

      var authorizeButton = document.getElementById('authorize_button');
      var signoutButton = document.getElementById('signout_button');

      
      
      /**
       *  On load, called to load the auth2 library and API client library.
       */
       function test(){
    	  
    	 let year=  opener.document.getElementById("year").value;
    	 let month=  opener.document.getElementById("month").value;
    	 let day=  opener.document.getElementById("day").value;
    	 let shour=  opener.document.getElementById("shour").value;
    	 let smin=  opener.document.getElementById("smin").value;
    	 let ehour=  opener.document.getElementById("ehour").value;
    	 let emin=  opener.document.getElementById("emin").value;
    	 let classname=  opener.document.getElementById("classname").value;
    	    
    	 
    	 var event = {
		  		  'summary': classname ,
		  		  'location': '서울특별시 성북구 ',
		  		  'description': '',
		  		  'start': {
		  		    'dateTime':  year+'-'+month+'-'+day+'T'+shour+':'+smin+':00+09:00' ,
		  		    'timeZone': 'Asia/Seoul'
		  		  },
		  		  'end': {
		  		    'dateTime': year+'-'+month+'-'+day+'T'+ehour+':'+emin+':00+09:00' ,
		  		    'timeZone': 'Asia/Seoul'
		  		  },
		  		 
		  		  'attendees': [
		  		    {'email': 'lpage@example.com'},
		  		    {'email': 'sbrin@example.com'}
		  		  ],
		  		  'reminders': {
		  		    'useDefault': false,
		  		    'overrides': [
		  		      {'method': 'email', 'minutes': 24 * 60},
		  		      {'method': 'popup', 'minutes': 10}
		  		    ]
		  		  }
		  		};

    	  		var request = gapi.client.calendar.events.insert({
    	  		  'calendarId': 'leewonsuck95@gmail.com',
    	  		  'resource': event
    	  		});

    	  		request.execute(function(event) {
    	  		  //appendPre('Event created: ' + event.htmlLink);
    	  		appendPre('캘린더에 추가 완료. 로그아웃 및 종료 버튼을 눌러주세요.');
  	  		  
    	  		});

    	  
    	    }

       
      function handleClientLoad() {
        gapi.load('client:auth2', initClient);
      }

      /**
       *  Initializes the API client library and sets up sign-in state
       *  listeners.
       */
      function initClient() {
        gapi.client.init({
          apiKey: API_KEY,
          clientId: CLIENT_ID,
          discoveryDocs: DISCOVERY_DOCS,
          scope: SCOPES
        }).then(function () {
          // Listen for sign-in state changes.
          gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);

          // Handle the initial sign-in state.
         // updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
          
          authorizeButton.onclick = handleAuthClick;
          signoutButton.onclick = handleSignoutClick;
        }, function(error) {
          appendPre(JSON.stringify(error, null, 2));
        });
      }

      /**
       *  Called when the signed in status changes, to update the UI
       *  appropriately. After a sign-in, the API is called.
       */
      function updateSigninStatus(isSignedIn) {
        if (isSignedIn) {
          authorizeButton.style.display = 'none';
          signoutButton.style.display = 'block';
          listUpcomingEvents();
         
         // handleSignoutClick;
          

        } else {
          authorizeButton.style.display = 'block';
          signoutButton.style.display = 'none';
        }
      }

      /**
       *  Sign in the user upon button click.
       		auth버튼 클릭시 작동
       */
      function handleAuthClick(event) {
        
        		gapi.auth2.getAuthInstance().signIn();
                
      }

      /**
       *  Sign out the user upon button click.
       */
      function handleSignoutClick(event) {
        gapi.auth2.getAuthInstance().signOut();
        window.close();
      }

      /**
       * Append a pre element to the body containing the given message
       * as its text node. Used to display the results of the API call.
       *
       * @param {string} message Text to be placed in pre element.
       */
      function appendPre(message) {
        var pre = document.getElementById('content');
        var textContent = document.createTextNode(message + '\n');
        pre.appendChild(textContent);
      }

      /**
       * Print the summary and start datetime/date of the next ten events in
       * the authorized user's calendar. If no events are found an
       * appropriate message is printed.
       */
      function listUpcomingEvents() {
        gapi.client.calendar.events.list({
          'calendarId': 'primary',
          'timeMin': (new Date()).toISOString(),
          'showDeleted': false,
          'singleEvents': true,
          'maxResults': 10,
          'orderBy': 'startTime'
        }).then(function(response) {
        		
   
          test();
        });
      }

    </script>
	
    <script async defer src="https://apis.google.com/js/api.js"
      onload="this.onload=function(){};handleClientLoad()"
      onreadystatechange="if (this.readyState === 'complete') this.onload()">
    </script>
    
   
    
  </body>
</html>








