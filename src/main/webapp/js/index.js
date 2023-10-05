$(function () {
    const $err = $("#err");
    if ($err.text().trim().length === 0) {
        $err.css("display", "none");
    } else {
        $err.css("display", "block");
    }


    const $password = $("#password");
    const $eye_open = $("#eye-open");
    const $eye_close = $("#eye-close");
    const $hr = $("hr");

    $password.on("input", function () {
        if ($password.val() !== "" && $password.val() !== null) {
            if (!eyeExist()) {
                $eye_open.css("display", "block");
            }
        } else {
            $eye_open.css("display", "none");
            $eye_close.css("display", "none");
        }
    })

    $password.focus(function () {
        $hr.css("border", "1px solid rgb(18, 150, 219)");
    }).blur(function () {
        $hr.css("border", "1px solid #e5e5e5");
    })

    $eye_open.click(function () {
        $eye_open.css("display", "none");
        $eye_close.css("display", "block");
        $password.attr("type", "text");
    })

    $eye_close.click(function () {
        $eye_open.css("display", "block");
        $eye_close.css("display", "none");
        $password.attr("type", "password");
    })
})

function eyeExist() {
    return $("#eye-open").css("display") === "block" || $("#eye-close").css("display") === "block";
}

function checkForm() {
    $("#md5-password").val(md5($("#password").val()));
    return true;
}