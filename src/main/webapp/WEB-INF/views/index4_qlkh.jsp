<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Quản lý khách hàng</title>

    <meta name="description" content="overview & stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- Font Awesome 4.2.0 -->
    <link rel="stylesheet" href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />
    
    <!-- Bootstrap Icons CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.min.css" rel="stylesheet">

    <!-- Text fonts -->
    <link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />

    <!-- Ace styles -->
    <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
        <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->

    <!--[if lte IE 9]>
      <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->
    
    <!-- Ace settings handler -->
    <script src="assets/js/ace-extra.min.js"></script>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
     <style>
         .sidebar {
             height: 100vh;
             background-color: #343a40;
             position: fixed; /* Keep sidebar fixed */
             top: 0;
             left: 0;
         }
         .sidebar .nav-list {
             padding: 0; /* remove the top padding*/
         }
         .sidebar .nav-list > li {
             margin-bottom: 0;
             width: 100%;
         }



         .sidebar .nav-link {
             color: #fff;
             padding: 15px;
             border-radius: 5px;
             margin: 5px;
             display: flex;
             align-items: center;
         }
         .sidebar .nav-link > .menu-icon {
             margin-right: 10px; /* Adjust spacing for the icons */
             display: inline-block;
             min-width: 1.25em; /* to prevent text jumping */

         }
         .sidebar .nav-link > .menu-text {
             display: inline-block;
         }
         .sidebar .nav-link:hover {
             background-color: #495057;
         }
         .sidebar .nav-link.active {
             background-color: #0d6efd;
         }
         .dashboard-card {
             transition: transform 0.2s;
         }
         .dashboard-card:hover {
             transform: translateY(-5px);
         }
         .chart-container {
             height: 300px;
         }
         .main-content{
             margin-left: 200px;
         }
         .container-fluid{
             padding-right: 0px;
             padding-left: 0px;
             margin-right: auto;
             margin-left: auto;
         }

         #sidebar > ul > li{

             width: 100%;
         }
         *{
             font-family: 'Roboto', sans-serif;
             font-size: 14px;
         }

         .sidebar-shortcuts{
             margin: 10px;
         }
         .small, small {
             font-size: .875em;
             padding-left: 2rem;
         }
         .navbar{
             display: flex;
             justify-content: center;
         }

     </style>

</head>

<body class="no-skin">
    <div id="navbar" class="navbar navbar-default">
        <script type="text/javascript">
            try{ace.settings.check('navbar' , 'fixed')}catch(e){}
        </script>



            <div class="navbar-header pull-left">
                <a href="#" class="navbar-brand">
                    <small>
                        <i class="bi bi-buildings"></i>
                        Hệ thống quản lý căn hộ
                    </small>
                </a>
            </div>


        </div><!-- /.navbar-container -->
    </div>

    <div class="main-container" id="main-container">
        <script type="text/javascript">
            try{ace.settings.check('main-container' , 'fixed')}catch(e){}
        </script>

        <div id="sidebar" class="sidebar                  responsive">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>



            <ul class="nav nav-list ">
                <li class="">
                    <a href="/" class="nav-link">
                        <i class="bi bi-buildings"></i>
                        <span class="menu-text"> Dashboard </span>
                    </a>
                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="/quanlycanho" class="nav-link">
                        <i class="menu-icon fa fa-building"></i>
                        <span class="menu-text"> Quản lý căn hộ </span>
                    </a>
                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="/quanlyhopdong" class="nav-link">
                        <i class="menu-icon fa fa-file-text-o"></i>
                        <span class="menu-text"> Quản lý Hợp đồng </span>
                    </a>
                    <b class="arrow"></b>
                </li>

                <li class="active">
                    <a href="/quanlykhachhang" class="nav-link">
                        <i class="menu-icon bi bi-people"></i>
                        <span class="menu-text"> Quản lý khách hàng </span>
                    </a>
                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="/quanlythietbi" class="nav-link">
                        <i class="menu-icon bi bi-gear"></i>
                        <span class="menu-text"> Quản lý thiết bị </span>
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul><!-- /.nav-list -->
            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs" id="breadcrumbs">
                    <script type="text/javascript">
                        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                    </script>

                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Trang chủ</a>
                        </li>
                        <li class="active">Quản lý khách hàng</li>
                    </ul><!-- /.breadcrumb -->

                    <div class="nav-search" id="nav-search">
                        <form class="form-search">
                            <span class="input-icon">
                                <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                                <i class="ace-icon fa fa-search nav-search-icon"></i>
                            </span>
                        </form>
                    </div><!-- /.nav-search -->
                </div>

                <div class="page-content">
                        <div class="container-fluid">
        <div class="row">

            <!-- Main Content -->
             <!-- Main Content -->
<div class="col-md-12 bg-light">
    <div class="p-4">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Quản lý khách hàng</h2>
            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#customerModal">
                <i class="fas fa-plus me-2"></i>Thêm khách hàng
            </button>
        </div>

        <!-- Filter Section -->
        <div class="card mb-4">
            <div class="card-body">
                <div class="row g-3">
                    <div class="col-md-3">
                        <input type="text" class="form-control" placeholder="Tên khách hàng...">
                    </div>
                    <div class="col-md-2">
                        <input type="text" class="form-control" placeholder="Số điện thoại...">
                    </div>
                    <div class="col-md-2">
                        <select class="form-select">
                            <option>Trạng thái</option>
                            <option>Đang thuê</option>
                            <option>Đã hết hợp đồng</option>
                            <option>Chưa thuê</option>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-secondary w-100">
                            <i class="fas fa-search me-2"></i>Tìm kiếm
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Customers Table -->
        <div class="card">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Mã KH</th>
                                <th>Họ và tên</th>
                                <th>CCCD/CMND</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Căn hộ đang thuê</th>
                                <th>Trạng thái</th>
                                <th>Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>KH001</td>
                                <td>Nguyễn Văn A</td>
                                <td>079201XXXXXX</td>
                                <td>0901234567</td>
                                <td>nguyenvana@email.com</td>
                                <td>A101</td>
                                <td><span class="badge bg-success">Đang thuê</span></td>
                                <td>
                                    <button class="btn btn-sm btn-info me-1" title="Xem chi tiết" data-bs-toggle="modal" data-bs-target="#customerDetailModal">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                    <button class="btn btn-sm btn-warning me-1" title="Sửa">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                    <button class="btn btn-sm btn-danger" title="Xóa">
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal thêm khách hàng -->
<div class="modal fade" id="customerModal" tabindex="-1" aria-labelledby="customerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="customerModalLabel">Thêm khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="addCustomerForm">
                    <div class="mb-3">
                        <label class="form-label">Họ và tên</label>
                        <input type="text" name="fullName" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">CCCD/CMND</label>
                        <input type="text" name="identityCard" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số điện thoại</label>
                        <input type="tel" name="phone" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày sinh</label>
                        <input type="date" name="birthDate" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Địa chỉ thường trú</label>
                        <textarea name="address" class="form-control" rows="3" required></textarea>
                    </div>
                </form>
                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary">Lưu</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal xem chi tiết khách hàng -->
<div class="modal fade" id="customerDetailModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Chi tiết khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6">
                        <p><strong>Mã khách hàng:</strong> KH001</p>
                        <p><strong>Họ và tên:</strong> Nguyễn Văn A</p>
                        <p><strong>CCCD/CMND:</strong> 079201XXXXXX</p>
                        <p><strong>Số điện thoại:</strong> 0901234567</p>
                        <p><strong>Email:</strong> nguyenvana@email.com</p>
                        <p><strong>Ngày sinh:</strong> 01/01/1990</p>
                        <p><strong>Địa chỉ:</strong> 123 Đường ABC, Quận XYZ, TP.HCM</p>
                    </div>
                    <div class="col-md-6">
                        <h6 class="mb-3">Thông tin thuê căn hộ</h6>
                        <p><strong>Căn hộ đang thuê:</strong> A101</p>
                        <p><strong>Ngày bắt đầu:</strong> 01/01/2024</p>
                        <p><strong>Ngày kết thúc:</strong> 31/12/2024</p>
                        <p><strong>Giá thuê:</strong> 15,000,000đ/tháng</p>
                        <p><strong>Trạng thái:</strong> <span class="badge bg-success">Đang thuê</span></p>
                    </div>
                </div>
                <div class="mt-4">
                    <h6 class="mb-3">Lịch sử thuê căn hộ</h6>
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Căn hộ</th>
                                    <th>Thời gian</th>
                                    <th>Giá thuê</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>B202</td>
                                    <td>01/01/2023 - 31/12/2023</td>
                                    <td>12,000,000đ/tháng</td>
                                    <td><span class="badge bg-secondary">Đã kết thúc</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
             

        </div>
    </div>

                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->



        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div><!-- /.main-container -->

    <!-- basic scripts -->

    <!--[if !IE]> -->
    <script src="assets/js/jquery.2.1.1.min.js"></script>

    <!-- <![endif]-->

    <!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

    <!--[if !IE]> -->
    <script type="text/javascript">
        window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
    </script>

    <!-- <![endif]-->

    <!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
    <script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- page specific plugin scripts -->

    <!--[if lte IE 8]>
      <script src="assets/js/excanvas.min.js"></script>
    <![endif]-->
    <script src="assets/js/jquery-ui.custom.min.js"></script>
    <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
    <script src="assets/js/jquery.easypiechart.min.js"></script>
    <script src="assets/js/jquery.sparkline.min.js"></script>
    <script src="assets/js/jquery.flot.min.js"></script>
    <script src="assets/js/jquery.flot.pie.min.js"></script>
    <script src="assets/js/jquery.flot.resize.min.js"></script>

    <!-- ace scripts -->
    <script src="assets/js/ace-elements.min.js"></script>
    <script src="assets/js/ace.min.js"></script>

    <!-- inline scripts related to this page -->
    <script type="text/javascript">
        jQuery(function($) {
            $('.easy-pie-chart.percentage').each(function(){
                var $box = $(this).closest('.infobox');
                var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                var size = parseInt($(this).data('size')) || 50;
                $(this).easyPieChart({
                    barColor: barColor,
                    trackColor: trackColor,
                    scaleColor: false,
                    lineCap: 'butt',
                    lineWidth: parseInt(size/10),
                    animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
                    size: size
                });
            })
        
            $('.sparkline').each(function(){
                var $box = $(this).closest('.infobox');
                var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
                $(this).sparkline('html',
                                 {
                                    tagValuesAttribute:'data-values',
                                    type: 'bar',
                                    barColor: barColor ,
                                    chartRangeMin:$(this).data('min') || 0
                                 });
            });
        
        
          //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
          //but sometimes it brings up errors with normal resize event handlers
          $.resize.throttleWindow = false;
        
          var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
          var data = [
            { label: "social networks",  data: 38.7, color: "#68BC31"},
            { label: "search engines",  data: 24.5, color: "#2091CF"},
            { label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
            { label: "direct traffic",  data: 18.6, color: "#DA5430"},
            { label: "other",  data: 10, color: "#FEE074"}
          ]
          function drawPieChart(placeholder, data, position) {
              $.plot(placeholder, data, {
                series: {
                    pie: {
                        show: true,
                        tilt:0.8,
                        highlight: {
                            opacity: 0.25
                        },
                        stroke: {
                            color: '#fff',
                            width: 2
                        },
                        startAngle: 2
                    }
                },
                legend: {
                    show: true,
                    position: position || "ne", 
                    labelBoxBorderColor: null,
                    margin:[-30,15]
                }
                ,
                grid: {
                    hoverable: true,
                    clickable: true
                }
             })
         }
         drawPieChart(placeholder, data);
        
         /**
         we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
         so that's not needed actually.
         */
         placeholder.data('chart', data);
         placeholder.data('draw', drawPieChart);
        
        
          //pie chart tooltip example
          var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
          var previousPoint = null;
        
          placeholder.on('plothover', function (event, pos, item) {
            if(item) {
                if (previousPoint != item.seriesIndex) {
                    previousPoint = item.seriesIndex;
                    var tip = item.series['label'] + " : " + item.series['percent']+'%';
                    $tooltip.show().children(0).text(tip);
                }
                $tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
            } else {
                $tooltip.hide();
                previousPoint = null;
            }
            
         });
        
            /////////////////////////////////////
            $(document).one('ajaxloadstart.page', function(e) {
                $tooltip.remove();
            });
        
        
        
        
            var d1 = [];
            for (var i = 0; i < Math.PI * 2; i += 0.5) {
                d1.push([i, Math.sin(i)]);
            }
        
            var d2 = [];
            for (var i = 0; i < Math.PI * 2; i += 0.5) {
                d2.push([i, Math.cos(i)]);
            }
        
            var d3 = [];
            for (var i = 0; i < Math.PI * 2; i += 0.2) {
                d3.push([i, Math.tan(i)]);
            }
            
        
            var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
            $.plot("#sales-charts", [
                { label: "Domains", data: d1 },
                { label: "Hosting", data: d2 },
                { label: "Services", data: d3 }
            ], {
                hoverable: true,
                shadowSize: 0,
                series: {
                    lines: { show: true },
                    points: { show: true }
                },
                xaxis: {
                    tickLength: 0
                },
                yaxis: {
                    ticks: 10,
                    min: -2,
                    max: 2,
                    tickDecimals: 3
                },
                grid: {
                    backgroundColor: { colors: [ "#fff", "#fff" ] },
                    borderWidth: 1,
                    borderColor:'#555'
                }
            });
        
        
            $('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
            function tooltip_placement(context, source) {
                var $source = $(source);
                var $parent = $source.closest('.tab-content')
                var off1 = $parent.offset();
                var w1 = $parent.width();
        
                var off2 = $source.offset();
                //var w2 = $source.width();
        
                if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
                return 'left';
            }
        
        
            $('.dialogs,.comments').ace_scroll({
                size: 300
            });
            
            
            //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
            //so disable dragging when clicking on label
            var agent = navigator.userAgent.toLowerCase();
            if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
              $('#tasks').on('touchstart', function(e){
                var li = $(e.target).closest('#tasks li');
                if(li.length == 0)return;
                var label = li.find('label.inline').get(0);
                if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
            });
        
            $('#tasks').sortable({
                opacity:0.8,
                revert:true,
                forceHelperSize:true,
                placeholder: 'draggable-placeholder',
                forcePlaceholderSize:true,
                tolerance:'pointer',
                stop: function( event, ui ) {
                    //just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                    $(ui.item).css('z-index', 'auto');
                }
                }
            );
            $('#tasks').disableSelection();
            $('#tasks input:checkbox').removeAttr('checked').on('click', function(){
                if(this.checked) $(this).closest('li').addClass('selected');
                else $(this).closest('li').removeClass('selected');
            });
        
        
            //show the dropdowns on top or bottom depending on window height and menu position
            $('#task-tab .dropdown-hover').on('mouseenter', function(e) {
                var offset = $(this).offset();
        
                var $w = $(window)
                if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
                    $(this).addClass('dropup');
                else $(this).removeClass('dropup');
            });
        
        })
    </script>
	 <!-- Scripts -->

	 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
	 <script>
		 // Revenue Chart
		 const revenueChart = new Chart(document.getElementById('revenueChart'), {
			 type: 'line',
			 data: {
				 labels: ['T1', 'T2', 'T3', 'T4', 'T5', 'T6'],
				 datasets: [{
					 label: 'Doanh thu (triệu VNĐ)',
					 data: [450, 480, 460, 520, 580, 550],
					 borderColor: '#0d6efd',
					 tension: 0.1
				 }]
			 },
			 options: {
				 responsive: true,
				 maintainAspectRatio: false
			 }
		 });
 
		 // Apartment Chart
		 const apartmentChart = new Chart(document.getElementById('apartmentChart'), {
			 type: 'doughnut',
			 data: {
				 labels: ['Đã thuê', 'Còn trống', 'Đang sửa chữa'],
				 datasets: [{
					 data: [85, 12, 3],
					 backgroundColor: ['#198754', '#ffc107', '#dc3545']
				 }]
			 },
			 options: {
				 responsive: true,
				 maintainAspectRatio: false
			 }
		 });
 
		 // Activate sidebar links
		 $('.sidebar .nav-link').on('click', function() {
			 $('.sidebar .nav-link').removeClass('active');
			 $(this).addClass('active');
		 });

         // Xử lý sự kiện submit form thêm khách hàng
$('#customerModal form').on('submit', function(e) {
    e.preventDefault();
    
    // Lấy dữ liệu từ form
    const customerData = {
        fullName: $('#customerModal input[name="fullName"]').val(),
        identityCard: $('#customerModal input[name="identityCard"]').val(),
        phone: $('#customerModal input[name="phone"]').val(),
        email: $('#customerModal input[name="email"]').val(),
        birthDate: $('#customerModal input[name="birthDate"]').val(),
        address: $('#customerModal textarea[name="address"]').val()
    };

    // Validate dữ liệu
    if (!validateCustomerForm(customerData)) {
        return;
    }

    // Gọi API thêm khách hàng
    $.ajax({
        url: '/api/customers',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(customerData),
        success: function(response) {
            // Thêm khách hàng vào bảng
            addCustomerToTable(response);
            
            // Đóng modal và reset form
            $('#customerModal').modal('hide');
            $('#customerModal form')[0].reset();
            
            // Hiện thông báo thành công
            showNotification('success', 'Thêm khách hàng thành công');
        },
        error: function(xhr) {
            showNotification('error', 'Lỗi: ' + xhr.responseText);
        }
    });
});

// Hàm validate form
function validateCustomerForm(data) {
    if (!data.fullName || data.fullName.length < 2) {
        showNotification('error', 'Tên khách hàng không hợp lệ');
        return false;
    }
    
    if (!data.identityCard || !/^\d{9,12}$/.test(data.identityCard)) {
        showNotification('error', 'CCCD/CMND không hợp lệ');
        return false;
    }
    
    if (!data.phone || !/^0\d{9}$/.test(data.phone)) {
        showNotification('error', 'Số điện thoại không hợp lệ');
        return false;
    }
    
    if (!data.email || !/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(data.email)) {
        showNotification('error', 'Email không hợp lệ');
        return false;
    }
    
    return true;
}

// Hàm thêm khách hàng vào bảng
function addCustomerToTable(customer) {
    const newRow = `
        <tr>
            <td>${customer.id}</td>
            <td>${customer.fullName}</td>
            <td>${customer.identityCard}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
            <td>${customer.apartmentId || ''}</td>
            <td><span class="badge bg-secondary">Chưa thuê</span></td>
            <td>
                <button class="btn btn-sm btn-info me-1" title="Xem chi tiết">
                    <i class="fas fa-eye"></i>
                </button>
                <button class="btn btn-sm btn-warning me-1" title="Sửa">
                    <i class="fas fa-edit"></i>
                </button>
                <button class="btn btn-sm btn-danger" title="Xóa">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        </tr>
    `;
    $('table tbody').prepend(newRow);
}

// Hàm hiển thị thông báo
function showNotification(type, message) {
    // Tạo toast notification
    const toast = `
        <div class="toast align-items-center text-white bg-${type === 'success' ? 'success' : 'danger'} border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    ${message}
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    `;
    
    // Thêm toast vào container và hiển thị
    const toastContainer = $('.toast-container');
    if (toastContainer.length === 0) {
        $('body').append('<div class="toast-container position-fixed top-0 end-0 p-3"></div>');
    }
    $('.toast-container').append(toast);
    $('.toast').toast('show');
}
	 </script>
     


</body>
</style>
</html>