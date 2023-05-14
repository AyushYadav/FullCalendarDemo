let inputElem1, inputElem2, inputElem3, button, form;

document.addEventListener('DOMContentLoaded', function() {
  getCalendarData(draw);
  getElements();
  form.addEventListener('submit', function(event){
    event.preventDefault();
    submitForm();
  });


});


function submitForm(){
  var data = {
          title: inputElem1.value,
          start: inputElem2.value, 
          end: inputElem3.value, 
        };

  fetch('http://localhost:5544/api/saveCalendar', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(data)
        })
        .then(function(response) {
          if (response.ok) {
            // POST request successful
            console.log('Data sent successfully');
            location.reload();
          } else {
            // Error in POST request
            console.log('Error sending data');
          }
        })
        .catch(function(error) {
          console.log('Error:', error);
        });
    inputElem1 = '';
    inputElem2 = '';
    inputElem3 = '';
    
}

function getElements(){
  inputElem1 = document.getElementById("inp1");
  inputElem2 = document.getElementById("inp2");
  inputElem3 = document.getElementById("inp3");
  form = document.getElementById('calendarForm');
}




function draw(data){

  var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth',
      // initialDate: '2023-05-07',
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      events: data
    });

    calendar.render();

}


function getCalendarData(callback) {
  fetch('http://localhost:5544/api/getCalendar')
    .then(response => response.json())
    .then(data => {
      // Call the callback function with the data
      console.log(data);
      callback(data);
    })
    .catch(error => {
      // Handle any errors
      console.error('Error:', error);
    });
}




