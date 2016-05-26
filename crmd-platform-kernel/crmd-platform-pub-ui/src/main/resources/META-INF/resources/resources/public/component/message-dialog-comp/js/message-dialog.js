/* ========================================================================
 * message-dialog.js
 * 
 * Description : Singleton message dialog.
 *      Author : huangchao
 * Create date : 2014/9/24
 * ======================================================================== */
var MESSAGE_DIALOG;

(function($) {
	'use strict';
	
	var DIALOG_SIZES = {
		small: 'modal-sm',
		large: 'modal-lg'
	};
	
	var DIALOG_OPTIONS = {
		size: 'small', // 'small' or 'large'
		style: 'message-dialog-primary', // 'message-dialog-info', 'message-dialog-success', 'message-dialog-warning' or 'message-dialog-danger'
		icon: 'fa fa-info-circle', // 'fa fa-*' or 'glyphicon glyphicon-*'
		title: '提示'
	};
	
	function MessageDialog() {
		this.$dialog = $(
			'<div data-backdrop="false" data-keyboard="false" class="modal fade message-dialog" tabindex="-1" role="dialog">' +
			  '<div class="modal-dialog">' +
			    '<div class="modal-content">' +
			      '<div class="modal-header"><h4 class="modal-title"><span></span><span></span></h4></div>' +
			      '<div class="modal-body"><p></p></div><div class="modal-footer"></div>' +
			    '</div>' +
			  '</div>' +
			'</div>'
		);
	};
	
	MessageDialog.prototype = {
		
		close: function(callback) {
			this.$dialog.modal('hide');
			if (typeof callback === 'function') {
				callback();
			}
		},
		
		open: function(options) {
			options = $.extend({}, DIALOG_OPTIONS, options);
			
			// set content
			this.$dialog.children().removeClass().addClass('modal-dialog').addClass(DIALOG_SIZES[options.size]).addClass(options.style);
			this.$dialog.find('.modal-title > span:first-child').removeClass().addClass(options.icon);
			this.$dialog.find('.modal-title > span:last-child').text(options.title);
			this.$dialog.find('.modal-body > p').text(options.message);
			
			// create buttons
			var footer = this.$dialog.find('.modal-footer').empty(); // clear footer
			if ($.isArray(options.buttons) && options.buttons.length > 0) {
				footer.show();
				var that = this;
				$.each(options.buttons, function(index, button) {
					$('<button type="button" class="btn btn-sm"></button>').click(function() {
						that.close(button.click);
					}).addClass(button.style || 'btn-default').text(button.label || '按钮').appendTo(footer);
				});
			} else {
				footer.hide();
			}
			
			// show dialog
			this.$dialog.modal('show');
		},
		
		loading: function(message) {
			this.open({
				style: 'message-dialog-loading',
				message: message || '正在处理中，请稍候...'
			});
		},
		
		alert: function(options, button) {
			if (!options) return;
			if (typeof options === 'string') options = { message: options };
			button = $.extend({ label: '确定' }, typeof button === 'function' ? { click: button } : button);
			options.buttons = [ button ];
			this.open(options);
		},
		
		warning: function(options, button) {
			if (!options) return;
			if (typeof options === 'string') options = { message: options };
			options.title = '警告';
			options.icon = 'fa fa-exclamation-circle';
			options.style = 'message-dialog-warning';
			this.alert(options, button);
		},
		
		error: function(options, button) {
			if (!options) return;
			if (typeof options === 'string') options = { message: options };
			options.title = '错误';
			options.icon = 'fa fa-times-circle';
			options.style = 'message-dialog-danger';
			this.alert(options, button);
		},
		
		confirm: function(options, button1, button2) {
			if (!options) return;
			if (typeof options === 'string') options = { message: options };
			button1 = $.extend({ label: '是' }, typeof button1 === 'function' ? { click: button1 } : button1);
			button1.style = 'btn-primary';
			button2 = $.extend({ label: '否' }, typeof button2 === 'function' ? { click: button2 } : button2);
			options.buttons = [ button1, button2 ];
			options.title = '确认';
			options.icon = 'fa fa-question-circle';
			this.open(options);
		},
		
		deletion: function(options, button1, button2) {
			if (!options) return;
			if (typeof options === 'string') options = { message: options };
			button1 = $.extend({ label: '是' }, typeof button1 === 'function' ? { click: button1 } : button1);
			button1.style = 'btn-danger';
			button2 = $.extend({ label: '否' }, typeof button2 === 'function' ? { click: button2 } : button2);
			options.buttons = [ button1, button2 ];
			options.title = '删除';
			options.icon = 'fa fa-minus-circle';
			options.style = 'message-dialog-danger';
			this.open(options);
		}, 
		
		newInstance: function() {
			var temp = MESSAGE_DIALOG.NEW;
			if (!temp) {
				MESSAGE_DIALOG.NEW = new MessageDialog();
			}
			return MESSAGE_DIALOG.NEW;
		}
		
	};
	
	$(function() {
		MESSAGE_DIALOG = new MessageDialog();
	});
	
})(jQuery);