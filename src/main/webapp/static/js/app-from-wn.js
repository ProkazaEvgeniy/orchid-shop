var orchid = {
		
	createPhotoUploader : function() {
	      // https://github.com/kartik-v/bootstrap-fileinput
	      $("#productPhoto").fileinput({
	        uploadAsync : false,
	        showUpload : false,
	        allowedFileExtensions : [ 'jpg', 'png' ],
	        maxFileCount : 1
	      });
	      $('#productPhoto').on('fileclear', function() {
	        $('#currentPhoto').css('display', 'block');
	      });
	      $('#productPhoto').on('fileloaded', function() {
	        $('#currentPhoto').css('display', 'none');
	      });
	    },
};

$(function() {
    
    var init = function(){
      $('#loadMore').click(moreProducts);
    };
    
    var moreProducts = function() {
        var page = parseInt($('#productContainer').attr('data-product-number')) + 1;
        var total = parseInt($('#productContainer').attr('data-product-total'));
        if (page >= total) {
          return;
        }
        var url = '/fragment/more' + location.pathname + '?page=' + page;

        $('#loadMoreContainer').css('display', 'none');
        $('#loadMoreIndicator').css('display', 'block');
        $.ajax({
          url : url,
          success : function(data) {
            $('#loadMoreIndicator').css('display', 'none');
            $('#productContainer').append(data);
            $('#productContainer').attr('data-product-number', page);
            if (page >= total - 1) {
              $('#loadMoreIndicator').remove();
              $('#loadMoreContainer').remove();
            } else {
              $('#loadMoreContainer').css('display', 'block');
            }
          },
          error : function(data) {
            alert('Error');
          }
        });
      };
    
    
    init();
});

// ПЕРЕМЕЩЕНИЕ БЛОКОВ--------------------------------------------
$( function() {
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
    }
);

// ПОЯВЛЕНИЕ БЛОКОВ----------------------------------------------
!function(a){a.fn.viewportChecker=function(b){var c={classToAdd:"visible",classToRemove:"invisible",offset:100,repeat:!1,invertBottomOffset:!0,callbackFunction:function(a,b){},scrollHorizontal:!1};a.extend(c,b);var d=this,e={height:a(window).height(),width:a(window).width()},f=-1!=navigator.userAgent.toLowerCase().indexOf("webkit")?"body":"html";return this.checkElements=function(){var b,g;c.scrollHorizontal?(b=a(f).scrollLeft(),g=b+e.width):(b=a(f).scrollTop(),g=b+e.height),d.each(function(){var d=a(this),f={},h={};if(d.data("vp-add-class")&&(h.classToAdd=d.data("vp-add-class")),d.data("vp-remove-class")&&(h.classToRemove=d.data("vp-remove-class")),d.data("vp-offset")&&(h.offset=d.data("vp-offset")),d.data("vp-repeat")&&(h.repeat=d.data("vp-repeat")),d.data("vp-scrollHorizontal")&&(h.scrollHorizontal=d.data("vp-scrollHorizontal")),d.data("vp-invertBottomOffset")&&(h.scrollHorizontal=d.data("vp-invertBottomOffset")),a.extend(f,c),a.extend(f,h),!d.hasClass(f.classToAdd)||f.repeat){String(f.offset).indexOf("%")>0&&(f.offset=parseInt(f.offset)/100*e.height);var i=f.scrollHorizontal?Math.round(d.offset().left)+f.offset:Math.round(d.offset().top)+f.offset,j=f.scrollHorizontal?i+d.width():i+d.height();f.invertBottomOffset&&(j-=2*f.offset),g>i&&j>b?(d.removeClass(f.classToRemove),d.addClass(f.classToAdd),f.callbackFunction(d,"add")):d.hasClass(f.classToAdd)&&f.repeat&&(d.removeClass(f.classToAdd),f.callbackFunction(d,"remove"))}})},a(document).bind("touchmove MSPointerMove pointermove",this.checkElements),a(window).bind("load scroll touchmove",this.checkElements),a(window).resize(function(b){e={height:a(window).height(),width:a(window).width()},d.checkElements()}),this.checkElements(),this}}(jQuery);

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

//----------------------

$(function() {

	var viewEl = document.querySelector('.view'),
		gridEl = viewEl.querySelector('.grid'),
		items = [].slice.call(gridEl.querySelectorAll('.product')),
		basket;

	// the compare basket
	function CompareBasket() {
		this.el = document.querySelector('.compare-basket');
		this.compareCtrl = this.el.querySelector('.action--compare');
		this.compareWrapper = document.querySelector('.compare'),
		this.closeCompareCtrl = this.compareWrapper.querySelector('.action--close')
		
		this.itemsAllowed = 3;
		this.totalItems = 0;
		this.items = [];

		// compares items in the compare basket: opens the compare products wrapper
		this.compareCtrl.addEventListener('click', this._compareItems.bind(this));
		// close the compare products wrapper
		var self = this;
		this.closeCompareCtrl.addEventListener('click', function() {
			// toggle compare basket
			classie.add(self.el, 'compare-basket--active');
			// animate..
			classie.remove(viewEl, 'view--compare');
		});
	}

	CompareBasket.prototype.add = function(item) {
		// check limit
		if( this.isFull() ) {
			return false;
		}

		classie.add(item, 'product--selected');

		// create item preview element
		var preview = this._createItemPreview(item);
		// prepend it to the basket
		this.el.insertBefore(preview, this.el.childNodes[0]);
		// insert item
		this.items.push(preview);

		this.totalItems++;
		if( this.isFull() ) {
			classie.add(this.el, 'compare-basket--full');
		}

		classie.add(this.el, 'compare-basket--active');
	};

	CompareBasket.prototype._createItemPreview = function(item) {
		var self = this;

		var preview = document.createElement('div');
		preview.className = 'product-icon';
		preview.setAttribute('data-idx', items.indexOf(item));
		
		var removeCtrl = document.createElement('button');
		removeCtrl.className = 'action action--remove';
		removeCtrl.innerHTML = '<i class="fa fa-remove"></i><span class="action__text action__text--invisible">Remove product</span>';
		removeCtrl.addEventListener('click', function() {
			self.remove(item);
		});
		
		var productImageEl = item.querySelector('img.product__image').cloneNode(true);

		preview.appendChild(productImageEl);
		preview.appendChild(removeCtrl);

		var productInfo = item.querySelector('.product__info').innerHTML;
		preview.setAttribute('data-info', productInfo);

		return preview;
	};

	CompareBasket.prototype.remove = function(item) {
		classie.remove(this.el, 'compare-basket--full');
		classie.remove(item, 'product--selected');
		var preview = this.el.querySelector('[data-idx = "' + items.indexOf(item) + '"]');
		this.el.removeChild(preview);
		this.totalItems--;

		var indexRemove = this.items.indexOf(preview);
		this.items.splice(indexRemove, 1);

		if( this.totalItems === 0 ) {
			classie.remove(this.el, 'compare-basket--active');
		}

		// checkbox
		var checkbox = item.querySelector('.action--compare-add > input[type = "checkbox"]');
		if( checkbox.checked ) {
			checkbox.checked = false;
		}
	};

	CompareBasket.prototype._compareItems = function() {
		var self = this;

		// remove all previous items inside the compareWrapper element
		[].slice.call(this.compareWrapper.querySelectorAll('div.compare__item')).forEach(function(item) {
			self.compareWrapper.removeChild(item);
		});

		for(var i = 0; i < this.totalItems; ++i) {
			var compareItemWrapper = document.createElement('div');
			compareItemWrapper.className = 'compare__item';

			var compareItemEffectEl = document.createElement('div');
			compareItemEffectEl.className = 'compare__effect';

			compareItemEffectEl.innerHTML = this.items[i].getAttribute('data-info');
			compareItemWrapper.appendChild(compareItemEffectEl);

			this.compareWrapper.insertBefore(compareItemWrapper, this.compareWrapper.childNodes[0]);
		}

		setTimeout(function() {
			// toggle compare basket
			classie.remove(self.el, 'compare-basket--active');
			// animate..
			classie.add(viewEl, 'view--compare');
		}, 25);
	};

	CompareBasket.prototype.isFull = function() {
		return this.totalItems === this.itemsAllowed;
	};

	function init() {
		// initialize an empty basket
		basket = new CompareBasket();
		initEvents();
	}

	function initEvents() {
		items.forEach(function(item) {
			var checkbox = item.querySelector('.action--compare-add > input[type = "checkbox"]');
			checkbox.checked = false;

			// ctrl to add to the "compare basket"
			checkbox.addEventListener('click', function(ev) {
				if( ev.target.checked ) {
					if( basket.isFull() ) {
						ev.preventDefault();
						return false;
					}
					basket.add(item);
				}
				else {
					basket.remove(item);
				}
			});
		});
	}

	init();

})();
