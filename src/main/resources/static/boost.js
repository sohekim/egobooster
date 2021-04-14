$(document).ready(function () {

  $('#searchButton').click(function () {
    $.ajax(
        {
          type: "GET",
          url: '/api/v1/boosters',
          data: {keyword: $('#myPlaceholder').val()},
          contentType: "application/json",
          dataType: "text",
          success: function (res) {
            $('#myPlaceholder').val("");

            let obj = JSON.parse(res);
            let index = Math.floor(Math.random() * Math.floor(obj.length))
            console.log(obj)
            // console.log(index)
            $('#boosterText').text(obj[index].text);
            $('#slipId').val(obj[index].id);
            $('#myPlaceholder').text('');
          },
          error: function (xhr, status, error) {
            alert("Oops, No booster found containing " +
                $('#myPlaceholder').val() +
                ".\nPlease try another keyword!");
            $('#myPlaceholder').val("");
          }
        }
    );
    return false;
  });

  $('#randomButton').click(function () {
    $.ajax(
        {
          type: "GET",
          url: '/api/v1/boosters/random',
          contentType: "application/json",
          dataType: "text",
          success: function (res) {
            let obj = JSON.parse(res);
            console.log(obj)
            $('#slipId').val(obj.id);
            $('#boosterText').text(obj.text);
          },
        }
    );
    return false;
  });

  $('#love').click(function () {
    $.ajax(
        {
          type: "PUT",
          url: '/api/v1/love',
          contentType: "application/json",
          dataType: "text",
          success: function (res) {
            let obj = JSON.parse(res);
            console.log(obj)
            $('#loveCount').text(obj.count);
          },
          // error: function (xhr, status, error) {
          //   alert("Oops, No booster found containing " +
          //       $('#myPlaceholder').val() +
          //       ". Please try another keyword!");
          // }
        }
    );
    return false;
  });

  function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
  }

  $('#subscribeButton').click(function () {
    let address = $('#subscribePlaceholder').val().trim();
    if (!validateEmail(address)) {
      alert(
          "Please enter a valid email address.");
    } else {
      $.ajax(
          {
            type: "POST",
            url: '/api/v1/subscriptions',
            data: JSON.stringify({email: address}),
            contentType: "application/json",
            dataType: "text",
            success: function (res) {
              $('#subscribePlaceholder').val("");
              console.log(res)
              alert(
                  "Email successfully subscribed!\nHope you have a more 'boosted' day :)");
            },
            error: function (xhr, status, error) {
              $('#subscribePlaceholder').val("");
              alert(
                  "This email seems to be already subscribed to EgoBooster!\nTry a different email.");
            }
          }
      );
    }

    return false;
  });

  $('#personalizeButton').click(function () {
    // check if i can get the words correctly
    let giftee = $('#giftee').val();
    let gifter = $('#gifter').val();
    let id = $('#slipId').val();
    $('#giftee').val("");
    $('#gifter').val("");
    if (giftee == "" && gifter == "") {
      alert("Oops, you need to input at least one field.");
    } else if (giftee == "") {
      window.open(`/${id}/gifter/${gifter}`)
    } else if (gifter == "") {
      window.open(`/${id}/giftee/${giftee}`)
    } else {
      window.open(`/${id}/${giftee}/${gifter}`)
    }
  });

  $('#personalizeSampleButton').click(function () {
    document.getElementById('personalizedContainer').style.display = 'block';
    document.getElementById('subscriptionContainer').style.display = 'none';
  });

  $('#subscriptionSampleButton').click(function () {
    document.getElementById('personalizedContainer').style.display = 'none';
    document.getElementById('subscriptionContainer').style.display = 'block';
  });

});