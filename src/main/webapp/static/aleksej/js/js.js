//FUNCTION SCROLLIFY----------------------------------------------------
$.scrollify({
    section : "section",
    sectionName : "section-name",
    easing: "easeOutExpo",
    scrollSpeed: 1800,
    offset : 0,
    scrollbars: true,
    before:function() {},
    after:function() {}
});

//ПЛАВАЮЩЕЕ МЕНЮ ХЕДЕР
$(function(){
  var h_hght = $('.page2').outerHeight(); // высота "шапки", px
  var h_nav = $('header').outerHeight(); // высота блока с меню, px
  var top;
    $(window).scroll(function(){
           top = $(this).scrollTop();  // отступ сверху
           if((h_hght-top) <= h_nav){
               $('header').css('top','0');
           }
           else if(top < h_hght && top > 0){
               $('header').css({'bottom' : top, 'top':''});
           }
           else if(top < h_nav){
               $('header').css({'top':'','bottom':'0'});
           }
       });
   }); 

//ПОЯВЛЕНИЕ БЛОКОВ----------------------------------------------
!function(a){a.fn.viewportChecker=function(b){var c={classToAdd:"visible",classToRemove:"invisible",offset:100,repeat:!1,invertBottomOffset:!0,callbackFunction:function(a,b){},scrollHorizontal:!1};a.extend(c,b);var d=this,e={height:a(window).height(),width:a(window).width()},f=-1!=navigator.userAgent.toLowerCase().indexOf("webkit")?"body":"html";return this.checkElements=function(){var b,g;c.scrollHorizontal?(b=a(f).scrollLeft(),g=b+e.width):(b=a(f).scrollTop(),g=b+e.height),d.each(function(){var d=a(this),f={},h={};if(d.data("vp-add-class")&&(h.classToAdd=d.data("vp-add-class")),d.data("vp-remove-class")&&(h.classToRemove=d.data("vp-remove-class")),d.data("vp-offset")&&(h.offset=d.data("vp-offset")),d.data("vp-repeat")&&(h.repeat=d.data("vp-repeat")),d.data("vp-scrollHorizontal")&&(h.scrollHorizontal=d.data("vp-scrollHorizontal")),d.data("vp-invertBottomOffset")&&(h.scrollHorizontal=d.data("vp-invertBottomOffset")),a.extend(f,c),a.extend(f,h),!d.hasClass(f.classToAdd)||f.repeat){String(f.offset).indexOf("%")>0&&(f.offset=parseInt(f.offset)/100*e.height);var i=f.scrollHorizontal?Math.round(d.offset().left)+f.offset:Math.round(d.offset().top)+f.offset,j=f.scrollHorizontal?i+d.width():i+d.height();f.invertBottomOffset&&(j-=2*f.offset),g>i&&j>b?(d.removeClass(f.classToRemove),d.addClass(f.classToAdd),f.callbackFunction(d,"add")):d.hasClass(f.classToAdd)&&f.repeat&&(d.removeClass(f.classToAdd),f.callbackFunction(d,"remove"))}})},a(document).bind("touchmove MSPointerMove pointermove",this.checkElements),a(window).bind("load scroll touchmove",this.checkElements),a(window).resize(function(b){e={height:a(window).height(),width:a(window).width()},d.checkElements()}),this.checkElements(),this}}(jQuery);

//ПЕРЕМЕЩЕНИЕ БЛОКОВ-----------------------------------------------------------
$( function() {
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
    }
);

//FUNCTION FIRST SUM----------------------------------------------------
function Test_1() {
	var first = document.getElementById('text_1').value;
	var second = document.getElementById('text_2').value;
	var sum = +first + +second;
		window.document.getElementById("ts").innerHTML = sum;
}

//FUNCTION NEXT BOOLEN-----------------------------------------------------------------
function Test_2() {
	var first = document.getElementById('text_1').value;
	var second = document.getElementById('text_2').value;
		if (first == second) {
			window.document.getElementById("ts").innerHTML = "Numbers are  <i>equal</i>";
			}
			else {
				window.document.getElementById("ts").innerHTML = "Numbers are  <i>not equal</i>";
			}
}

//FUNCTION FOR------------------------------------------------------------------------------
function Test_3() {
	var first = document.getElementById('text_1').value;
	var second = document.getElementById('text_2').value;
	for(var s=first; s < second; s++) {
		window.document.getElementById("ts").innerHTML += s;
	}
}

//FUNCTION SLIDER---------------------------------------------------
var total_pics_num = 5;   // количество изображений
var interval = 2000;      // задержка между изображениями
var time_out = 0.3;       // задержка смены изображений
var i = 0;
var timeout;
var opacity = 100;
function fade_to_next(){
	opacity--;
var k = i + 1;
var image_now = 'image_' + i;
	if (i == total_pics_num) k = 1;
	var image_next = 'image_' + k;
		document.getElementById(image_now).style.filter = 'alpha(opacity='+ opacity +')';
		document.getElementById(image_next).style.filter = 'alpha(opacity='+ (100-opacity) +')';
        document.getElementById(image_now).style.opacity = opacity/100;
		document.getElementById(image_next).style.opacity = (100-opacity)/100;
timeout = setTimeout("fade_to_next()", time_out);
if (opacity==1){  
	opacity = 100;
		clearTimeout(timeout);
   }
}
setInterval (
function(){
    i++;
    if (i > total_pics_num) i=1;
    fade_to_next();
    }, interval
);

//FUNCTION TIME-----------------------------------------------------------------
function clockTimer(){
var date = new Date();
var time = [date.getHours(),date.getMinutes(),date.getSeconds()];
var dayOfWeek = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
var days = date.getDay();
if(time[0] < 10){time[0] = "0"+ time[0];}
if(time[1] < 10){time[1] = "0"+ time[1];}
if(time[2] < 10){time[2] = "0"+ time[2];}
var current_time = [time[0],time[1],time[2]].join(':');
window.document.getElementById("clock").innerHTML = current_time;
window.document.getElementById("dayOfWeek").innerHTML = dayOfWeek[days];
setTimeout("clockTimer()", 1000);
}

//ОТКРЫТЬ ЗАКРЫТЬ БЛОК VID -------------------------------------------------------
document.onclick = function(event) {
    var target = event.target;
    var id = target.getAttribute('data-toggle-id');
    if (!id) return;
    var elem = document.getElementById(id);
    elem.hidden = !elem.hidden;
};

//ОТКРЫТЬ ЗАКРЫТЬ КОНСОЛЬ-------------------------------------------------------
function Console_On_Off(terminal) {
    var obj = document.getElementById("terminal");
        if (obj.style.display != "block") {
            obj.style.display = "block";
        }
        else obj.style.display = "none";  
}

//ВЫВОД ИНФОРМАЦИИ----------------------------------------------------------------
function c() {
var n1 = window.document.getElementById("wi").value;
var n2 = window.document.getElementById("len").value;
var n3 = window.document.getElementById("hei").value;
var n4 = window.document.getElementById("flo").value;
var n5 = window.document.getElementById("ws").value;
var n6 = window.document.getElementById("p").value;
var n7 = window.document.getElementById("k").value;
window.document.getElementById("in1").innerHTML = n1 * n2;
window.document.getElementById("in2").innerHTML = (( n1*2 + n2*2 ) * n3) * n4;
window.document.getElementById("in3").innerHTML = n5*n3;
window.document.getElementById("in4").innerHTML = n6*n3;
window.document.getElementById("in5").innerHTML = n1 * n2;
window.document.getElementById("in6").innerHTML = (( Math.sqrt((( n1 / 2 ) * ( n1 / 2 )) + ( n7 * n7 ))) * n2) * 2;
}

//FUNCTION TERMINAL CONSOLE---------------------------------------------------------------
(function () {
    function translit(text){
        return text.replace(/[а-яА-Я]/g, function (match) {
            return '_x' + match.charCodeAt() + 'x_';
        });
    }
    function detranslit(text) {
        return text.replace(/_x(\d+)x_/g, function (match, code) {
            return String.fromCharCode(code);
        });
    }
    function Calque(inputEl, outputEl) {
        this.inputEl = inputEl;
        this.outputEl = outputEl;
        this.parentEl = inputEl.parentNode;
        this.raw = '';
        this.lines = [];
        this.expressions = [];
        this.activeLine = 0;
        var handler = function () {
            this.updateActiveLine();
            this.input();
            this.inputEl.style.height = Math.max(
                this.outputEl.clientHeight,
                this.parentEl.clientHeight
            ) + 'px';
        }.bind(this);
        handler();
        this.inputEl.onkeydown = handler;
        this.inputEl.onkeyup = handler;
        setInterval(handler, 50);
        this.outputEl.scrollTop = this.inputEl.scrollTop;
    }
    Calque.prototype.updateActiveLine = function () {
        var value = this.inputEl.value;
        var selectionStart = this.inputEl.selectionStart;
        var match = value.substr(0, selectionStart).match(/\n/g);
        if (!match) {
            var activeLine = 1;
        } else {
            var activeLine = value.substr(0, selectionStart).match(/\n/g).length + 1;
        }
        if (this.activeLine !== activeLine) {
            this.activeLine = activeLine;
            this.repaint();
        }
    }
    Calque.prototype.input = function () {
        var raw = this.inputEl.value;
        if (raw !== this.raw) {
            this.raw = raw;
            this.lines = this.raw.split("\n");
            this.recalc();
        }
    }
    Calque.prototype.recalc = function () {
        this.expressions = [];
        var spacevars = [];
        var sums = [];
        var scope = {
            last: null
        };
        this.lines.forEach(function (code, index) {
            var expression = {
                line: index,
                code: code,
                processed: code,
                result: null,
                error: null,
            }
            this.expressions.push(expression);
            if (expression.code.substr(0, 2) === '  ') {
                expression.tab = expression.code.match(/\s+/)[0].match(/\s{2}/g).length;
            } else {
                expression.tab = 0;
            }
            if (expression.code.trim() !== '' && expression.tab < sums.length) {
                var closed = sums.splice(expression.tab);
            }
            if (expression.processed.indexOf('=') > 0) {
                var names = [];
                expression.processed.split('=').slice(0, -1).forEach(function (part) {
                    if (expression.processed.indexOf('(') > 0) {
                        names.push(part.substr(0, part.indexOf('(')).trim());
                    } else {
                        names.push(part.trim());
                    }
                });
                names.forEach(function (name) {
                    spacevars.splice(0, 0, {
                        original: name,
                        replaced: name.replace(/ /g, '_'),
                        regexp: new RegExp(name, 'g')
                    });
                });
            }
            if (expression.processed.trim().slice(-1) === ':') {
                var name = expression.processed.trim().slice(0, -1).trim();
                expression.variable = translit(name.replace(/ /g, '_'));
                spacevars.splice(0, 0, {
                    original: name,
                    replaced: name.replace(/ /g, '_'),
                    regexp: new RegExp(name, 'g')
                });
                if (expression.tab === sums.length) {
                    sums.push(expression);
                } else {
                    expression.error = 'Error: Unexpected indent';
                }
                expression.processed = name + ' = 0';
            }
            spacevars.forEach(function (spacevar) {
                expression.processed = expression.processed.replace(spacevar.regexp, spacevar.replaced);
            });
            expression.processed = translit(expression.processed);
            try {
                expression.result = math.eval(expression.processed, scope);
            } catch (e) {
                expression.error = detranslit(e.toString());
            }
            if (expression.result !== undefined) {
                scope.last = expression.result;
            }
            if (sums.length && expression.result && !expression.error) {
                sums.forEach(function (sum) {
                    if (!sum.error) {
                        try {
                            sum.result = math.add(sum.result, expression.result);
                            scope[sum.variable] = sum.result;
                        } catch (e) {
                            sum.error = 'Error: Sum can not be calculated';
                        }
                    }
                });
            }
        }.bind(this));
        this.repaint();
    };
    Calque.prototype.repaint = function () {
        var html = '';
        this.lines.forEach(function (line, index) {
            var expression = this.expressions.filter(function (expression) {
                return expression.line === index;
            })[0];
            if (expression.error) {
                if (this.activeLine === index + 1) {
                    var type = 'empty';
                } else {
                    var type = 'error';
                }
            } else if (expression.result === undefined) {
                var type = 'empty';
                for (var i = index; i < this.lines.length; i++) {
                    if (this.expressions[i].result !== undefined) {
                        expression.tab = this.expressions[i].tab;
                        break;
                    }
                }
            } else {
                var type = 'result';
            }
            var prefix = '';
            for (var s = 0; s <= expression.code.length; s++) prefix += ' ';
            if (type === 'empty') for (var t = 0; t <= expression.tab; t++) prefix += '  ';
            for (var i = 0; i < expression.tab; i++) prefix = prefix.replace(/(\| )?  /, '$1| ');
            if (type === 'result') {
                if (expression.result instanceof Function) {
                    prefix += 'fn';
                } else {
                    prefix += '= ';
                }
            }
            if (type === 'error') prefix += '// ';
            var data = '';
            if (type === 'result') {
                if (expression.result === null) {
                    data = 'null';
                } else if (expression.result instanceof Function) {
                    var source = expression.result.toString();
                    data = '';
                } else {
                    data = expression.result.toString();
                }
            };
            if (type === 'error') data = expression.error;
            var lineHtml = '<div class="' + type + '">';
            lineHtml += '<span class="prefix" data-prefix="' + prefix + '"></span>';
            lineHtml += '<span class="data">' + data + '</span>';
            lineHtml += '</div>';
            html += lineHtml;
        }.bind(this));
        this.outputEl.innerHTML = html;
    };
    window.Calque = Calque;
})();

//-----------------------------------------------------------------------
function rot_box_nature_1() {
    but_nature_1.onclick = function() {
    document.getElementById('nature').style.transform = 'rotateY(90deg)';
    document.getElementById('but_nature_1').style.display="none";
    document.getElementById('but_nature_2').style.display="block";
};
}
function rot_box_nature_2() {
but_nature_2.onclick = function() {
    document.getElementById('nature').style.transform = 'rotateY(180deg)';
    document.getElementById('but_nature_2').style.display="none";
    document.getElementById('but_nature_3').style.display="block";
};
}
function rot_box_nature_3() {
but_nature_3.onclick = function() {
    document.getElementById('nature').style.transform = 'rotateY(270deg)';
    document.getElementById('but_nature_3').style.display="none";
    document.getElementById('but_nature_4').style.display="block";
};
}
function rot_box_nature_4() {
but_nature_4.onclick = function() {
    document.getElementById('nature').style.transform = 'rotateY(360deg)';
    document.getElementById('but_nature_4').style.display="none";
    document.getElementById('but_nature_1').style.display="block";
};
}
//-----------------------------------------------------------------------
function rot_box_home_1() {
    but_home_1.onclick = function() {
    document.getElementById('home').style.transform = 'rotateY(90deg)';
    document.getElementById('but_home_1').style.display="none";
    document.getElementById('but_home_2').style.display="block";
};
}
function rot_box_home_2() {
but_home_2.onclick = function() {
    document.getElementById('home').style.transform = 'rotateY(180deg)';
    document.getElementById('but_home_2').style.display="none";
    document.getElementById('but_home_3').style.display="block";
};
}
function rot_box_home_3() {
but_home_3.onclick = function() {
    document.getElementById('home').style.transform = 'rotateY(270deg)';
    document.getElementById('but_home_3').style.display="none";
    document.getElementById('but_home_4').style.display="block";
};
}
function rot_box_home_4() {
but_home_4.onclick = function() {
    document.getElementById('home').style.transform = 'rotateY(360deg)';
    document.getElementById('but_home_4').style.display="none";
    document.getElementById('but_home_1').style.display="block";
};
}
//-----------------------------------------------------------------------
function rot_box_sculpture_1() {
    but_sculpture_1.onclick = function() {
    document.getElementById('sculpture').style.transform = 'rotateY(90deg)';
    document.getElementById('but_sculpture_1').style.display="none";
    document.getElementById('but_sculpture_2').style.display="block";
};
}
function rot_box_sculpture_2() {
but_sculpture_2.onclick = function() {
    document.getElementById('sculpture').style.transform = 'rotateY(180deg)';
    document.getElementById('but_sculpture_2').style.display="none";
    document.getElementById('but_sculpture_3').style.display="block";
};
}
function rot_box_sculpture_3() {
but_sculpture_3.onclick = function() {
    document.getElementById('sculpture').style.transform = 'rotateY(270deg)';
    document.getElementById('but_sculpture_3').style.display="none";
    document.getElementById('but_sculpture_4').style.display="block";
};
}
function rot_box_sculpture_4() {
but_sculpture_4.onclick = function() {
    document.getElementById('sculpture').style.transform = 'rotateY(360deg)';
    document.getElementById('but_sculpture_4').style.display="none";
    document.getElementById('but_sculpture_1').style.display="block";
};
}
//-----------------------------------------------------------------------
function rot_box_art_1() {
    but_art_1.onclick = function() {
    document.getElementById('art').style.transform = 'rotateY(90deg)';
    document.getElementById('but_art_1').style.display="none";
    document.getElementById('but_art_2').style.display="block";
};
}
function rot_box_art_2() {
but_art_2.onclick = function() {
    document.getElementById('art').style.transform = 'rotateY(180deg)';
    document.getElementById('but_art_2').style.display="none";
    document.getElementById('but_art_3').style.display="block";
};
}
function rot_box_art_3() {
but_art_3.onclick = function() {
    document.getElementById('art').style.transform = 'rotateY(270deg)';
    document.getElementById('but_art_3').style.display="none";
    document.getElementById('but_art_4').style.display="block";
};
}
function rot_box_art_4() {
but_art_4.onclick = function() {
    document.getElementById('art').style.transform = 'rotateY(360deg)';
    document.getElementById('but_art_4').style.display="none";
    document.getElementById('but_art_1').style.display="block";
};
}
//-----------------------------------------------------------------------
function rot_box_weapon_1() {
    but_weapon_1.onclick = function() {
    document.getElementById('weapon').style.transform = 'rotateY(90deg)';
    document.getElementById('but_weapon_1').style.display="none";
    document.getElementById('but_weapon_2').style.display="block";
};
}
function rot_box_weapon_2() {
but_weapon_2.onclick = function() {
    document.getElementById('weapon').style.transform = 'rotateY(180deg)';
    document.getElementById('but_weapon_2').style.display="none";
    document.getElementById('but_weapon_3').style.display="block";
};
}
function rot_box_weapon_3() {
but_weapon_3.onclick = function() {
    document.getElementById('weapon').style.transform = 'rotateY(270deg)';
    document.getElementById('but_weapon_3').style.display="none";
    document.getElementById('but_weapon_4').style.display="block";
};
}
function rot_box_weapon_4() {
but_weapon_4.onclick = function() {
    document.getElementById('weapon').style.transform = 'rotateY(360deg)';
    document.getElementById('but_weapon_4').style.display="none";
    document.getElementById('but_weapon_1').style.display="block";
};
}


//----------ОТКРЫТЬ ЗАКРЫТЬ SKETCH_3D -------------------------------------
function hide() {
    var obj_1 = document.getElementById("sketch_1").style.display = "none";
    var obj_2 = document.getElementById("sketch_2").style.display = "none";
    var obj_3 = document.getElementById("sketch_3").style.display = "none";
    var obj_4 = document.getElementById("sketch_4").style.display = "none";
    var obj_5 = document.getElementById("sketch_5").style.display = "none";
    var obj_6 = document.getElementById("sketch_6").style.display = "none";
}
btn_sketch_1.onclick = function show_hide_1() {
    var all = hide();
    obj_1 = sketch_1.style.display="block";
}
btn_sketch_2.onclick = function show_hide_2() {
    var all = hide();
    obj_2 = sketch_2.style.display="block";
}
btn_sketch_3.onclick = function show_hide_3() {
    var all = hide();
    obj_3 = sketch_3.style.display="block";
}
btn_sketch_4.onclick = function show_hide_4() {
    var all = hide();
    obj_4 = sketch_4.style.display="block";
}
btn_sketch_5.onclick = function show_hide_5() {
    var all = hide();
    obj_5 = sketch_5.style.display="block";
}
btn_sketch_6.onclick = function show_hide_6() {
    var all = hide();
    obj_6 = sketch_6.style.display="block";
}

//------------------------------------------------------
function NewWin() {
  NewDoc=window.open("", "NewWindow",
        "width=500, height=200, top=100, left=100, status=1, toolbar=1, menubar=1, directories=0");
    NewDoc.document.open();
    NewDoc.document.write("<html>");
    NewDoc.document.write("<head>");
    NewDoc.document.write("<title>Пример динамического ");
    NewDoc.document.write("создания документов</title>");
    NewDoc.document.write("</head>");
    NewDoc.document.write("<body>");
    NewDoc.document.write("<center>");
    NewDoc.document.write("<font size=+3>");
    NewDoc.document.write("Новая страница");
    NewDoc.document.write("</font>");
    NewDoc.document.write("</center>");
    NewDoc.document.write("</body>");
    NewDoc.document.write("</html>");
    NewDoc.document.close();
}



