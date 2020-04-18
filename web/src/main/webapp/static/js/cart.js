function showCart() {
    $.ajax({
        url: "allCarts",
        type: "post",
        dataType: "json",
        success: function (data) {
            if (data.msg == "请先登录") {
                alert(data.msg);
                window.location.href = "/index";
            } else {
                var content = "";
                var totalprice = 0;
                for (var i = 0; i < data.carts.length; i++) {
                    var po = data.carts[i];
                    content += "<tr>"
                        + "<td class='text-center'><img src='" + po.img + "' class='cart-img' /></td>"
                        + "<td class='infor'>" + po.bname + "</td>"
                        + "<td class='infor'>" + po.price + "元</td>"
                        + "<td class='infor'>" + po.count + "</td>"
                        + "<td class='infor'><button class='btn btn-primary' type='submit' "
                        + "onclick='removecart(" + po.bid + ")' >还书</button>"
                        + "</td>"
                        + "</tr>";
                    totalprice += po.price * po.count;
                }
                $("#cart").html(content);
            }
        }
    });
}

showCart();

function checkout() {
    $.ajax({
        url: "checkout",
        type: "post",
        data: {},
        dataType: 'json',
        success: function (data) {
            //alert(data);
            $("#checkout").html(data);
            //window.location.reload();
        }
    });

}

//checkout();

function removecart(pgid) {
	// alert("删除");
    $.ajax({
        url: "reCartBook",
        type: "post",
        data: {
            "bid": pgid,
            "ccount": 1,
        },
        dataType: "text",  //期待的响应数据类型
        success: function (data) {
            if (data == "已成功还书1本") {
                alert(data);
                window.location.reload();
            } else {
                alert(data);
                window.location.reload();
            }
        },
        error:function () {
            alert("系统出错，请联系帅气的管理员");
        }
    });
}


function showorder() {
    alert("你好")
    $.ajax({
        url: "showOrder",
        type: "post",
        dataType: 'json',  //期待的响应数据类型
        success: function (data) {
            alert(data);
            var content = "";
            for (var i = 0; i < data.length; i++) {
                var po = data[i];
                content += "<tr><th>订单号：" + po.oname + "，用户：" + po.luser + ",商品数量：" + po.ocount + ",商品id：" + po.bid + "，借书时间：" + po.bdate + "还书时间" + po.gdate + "</th></tr>";
            }
            $("#order").html(content);
        }
    });
}

