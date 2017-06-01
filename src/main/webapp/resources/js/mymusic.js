// Popup for Music===============================================================================
var buttonList = document.querySelectorAll('.usermusic button');
var popupList = document.querySelectorAll('.popup');
var popupInnerList = document.querySelectorAll('.popup-inner');
var popupCloseList = document.querySelectorAll('.popup-close');
var popupplaylist = document.getElementById('playlist'),
    popupmusic = document.getElementById('track');


for (var i = 0; i < buttonList.length; i++) {
    buttonList[i].onclick = function () {
        var popupId = this.dataset.music;
        document.getElementById(popupId).style.display = 'block';

    }
}

for (var i = 0; i < popupList.length; i++) {
    popupList[i].onclick = function () {
        this.style.display = '';
    }
}

for (var i = 0; i < popupInnerList.length; i++) {
    popupInnerList[i].onclick = function (event) {
        event.stopPropagation();
    }
}

for (var i = 0; i < popupCloseList.length; i++) {
    popupCloseList[i].onclick = function () {
        this.parentElement.parentElement.style.display = '';
    }
}

// Upload  Music(Single Track)===============================================================================
var isMp3 = function (name) {
    return name.match(/mp3$/i)
};

$(document).ready(function () {
    var file = $('[name="onefileaudio"]');
    var audioContaineraudio = $('#containeraudio');

    $('#uploadtrack').on('click', function () {
        popupplaylist.style.display = '';
        var filename = $.trim(file.val());
        if (!(isMp3(filename))) {
            alert("Please browse a Jpg/png file to upload");
            return;
        }
        $.ajax({
            url: "http://localhost:8080/greenapp/api/profile/putAudio",
            type: "POST",
            data: new FormData(document.getElementById("oneformaddmusic")),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false
        }).done(function (data) {
            console.log(data);
            audioContaineraudio.html(' ');
            var audio = '<audio src=' + data["path"] + ' controls/>';
            audioContaineraudio.append(audio);
        });
    });
});

//Для ПЛЕЙЛИСТОВ=====================================================================================================
// $('#createplaylist').on('click', function () {
//
//     $(document).ready(function () {
//         $.ajax({
//             url: "http://localhost:8080/greenapp/api/profile/sound/createFolder",
//             type: "POST",
//             data: new FormData(document.getElementById("formimglist")),
//             enctype: 'multipart/form-data',
//             processData: false,
//             contentType: false
//         }).done(function (data) {
//             window.location.href = 'url';
//         });
//     });

// });


//Avatar==============================================================================
// var idUser= document.getElementById("idUser").value;
var isJpg = function (name) {
    return name.match(/jpg$/i)
};
var isPng = function (name) {
    return name.match(/png$/i)
};

var idImageByPlaylist = 0;

$(document).ready(function () {
    var file = $('[name="filefoto"]');
    $('#uploadimgtrack').on('click', function () {
        var filename = $.trim(file.val());
        if (!(isJpg(filename) || isPng(filename))) {
            alert("Please browse a Jpg/png file to upload");
            return;
        }
        $.ajax({
            url: "http://localhost:8080/greenapp/api/profile/loadPhoto",
            type: "POST",
            data: new FormData(document.getElementById("formimglist")),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false
        }).done(function (data) {
            console.log("sata: " + data);
            idImageByPlaylist = data.image_id;
            $("#baseimgplaylist").attr("src", "data:" + data.contenttype + ";base64," + data.base64);

            // imgContainer.html(' ');
            // $('#baseimg').remove();
            // imgContainer.append(img);
        });
    });
});


function call() {
    var map = {
        name: $("input[name='name_playlist']").val(),
        description: $("input[name='description_playlist']").val(),
        image_id:idImageByPlaylist
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/greenapp/api/profile/sound/createFolder',
        data: map,
        success: function (data) {
            // window.location.href = data["path"];
            console.log("img_id: "+idImageByPlaylist);
        },
        error: function (xhr, str) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });

}