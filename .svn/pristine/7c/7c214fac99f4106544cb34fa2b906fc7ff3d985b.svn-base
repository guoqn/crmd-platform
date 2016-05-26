/**
 * 正在加载处理类。
 * 
 * @author huangchao
 */
function Loading(opts) {
	this._init();
}

Loading.start = function(message) {
	if (!Loading.instance) {
		Loading.instance = new Loading();
	}
	Loading.instance.start(message);
};
Loading.finish = function(message, delay, isStayCurrentPage) {
	if (Loading.instance) {
		Loading.instance.finish(message, delay, isStayCurrentPage);
	}
};
Loading.error = function(message, delay) {
	if (Loading.instance) {
		Loading.instance.error(message, delay);
	}
};

Loading.doFinish = function(callback, delay) {
	if (Loading.instance) {
		Loading.instance.doFinish(callback, delay);
	}
};

Loading.prototype = {
	
	/* 
	 * 结束操作。
	 */
	finishHandler : null,
	
	/**
	 * 开始执行操作。
	 * 
     * @param {string} message 提示信息
	 */
	start : function(message) {
		if (!message) {
			message = "正在处理中，请稍等...";
		}
		this.dialog.find(".modal-body").addClass("loading-icon");
		this.dialog.find(".modal-body > p").html(message);
		this.dialog.find(".modal-footer").hide();
		this.dialog.modal("show");
	},
	
	/**
	 * 操作执行完毕。
	 * 
     * @param {Object} message
	 */
	finish : function(message, delay, isStayCurrentPage) {
		if (delay) {
			var $this = this;
			setTimeout(function() {
				$this._finish(message, isStayCurrentPage);
			}, delay);
		} else {
			this._finish(message, isStayCurrentPage);
		}
	},
	
	_finish : function(message, isStayCurrentPage) {
		var $this = this;
		if (!message) {
			message = "处理完毕！";
		}
		this.dialog.find(".modal-body").removeClass("loading-icon");
		this.dialog.find(".modal-body > p").html(message);
		this.dialog.find(".modal-footer").show();
		this.dialog.on("hidden.bs.modal", function(e) {
			if ($this.finishHandler) {
				$this.finishHandler();
			} else {
				if (isStayCurrentPage) {
					window.location.reload();
				} else {
					$this._back();
				}
			}
		});
	},
	
	doFinish : function(callback, delay) {
		if (delay) {
			var $this = this;
			setTimeout(function() {
				$this.dialog.modal("hide");
				if (callback) {
					callback();
				}
			}, delay);
		} else {
			this.dialog.modal("hide");
			if (callback) {
				callback();
			}
		}
	},

	/**
	 * 操作执行异常。
	 * 
     * @param {Object} message
	 */
	error : function(message, delay) {
		if (delay) {
			var $this = this;
			setTimeout(function() {
				$this._error(message);
			}, delay);
		} else {
			this._error(message);
		}
	},
	_error : function(message) {
		if (!message) {
			message = "处理失败！";
		}
		this.dialog.find(".modal-body").removeClass("loading-icon");
		this.dialog.find(".modal-body > p").html(message);
		this.dialog.find(".modal-footer").show();
	},

	/**
	 * 返回上一次引用的URL地址。 
	 */
	_back : function() {
		window.location.href = Loading.referrer;
	},
	
	/**
	 * 初始化。 
	 */
	_init : function() {
		var dialogHtml =
			'<div class="modal fade" tabindex="-1" role="dialog">' +
				'<div class="modal-dialog modal-sm loading-dialog">' +
					'<div class="modal-content">' +
						'<div class="modal-body"><p style="word-wrap:break-word; word-break:break-all;"></p></div>' +
						'<div class="modal-footer" style="display: none;">' +
							'<button type="button" class="btn btn-success btn-sm" data-dismiss="modal">确定</button>' +
						'</div>' +
					'</div>' +
				'</div>' +
			'</div>';
		// 创建对话框对象
		this.dialog = $(dialogHtml);
		// 设置对话框初始化参数
		this.dialog.modal({
			backdrop : false,
			keyboard : false,
			show : false
		});
	}
	
};

