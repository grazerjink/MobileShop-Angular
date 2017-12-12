import { Component, OnInit, AfterViewInit} from '@angular/core';

declare const $

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit() {

  }

  ngAfterViewInit() {
    // $('#tabs a').tabs();  
    $("#related_pro").flexslider({animation: "slide",
      animationLoop: false,
      slideshow: false,
      itemWidth: 210,
      minItems: this.getGridSize(), // use function to pull in initial value
      maxItems: this.getGridSize() // use function to pull in initial value
    });
  }

  // "assets/template/js/jquery-1.7.1.min.js",
        // "assets/template/js/jquery.nivo.slider.pack.js",
        // "assets/template/js/jquery.flexslider.js",
        // "assets/template/js/jquery.easing-1.3.min.js",
        // "assets/template/js/jquery.jcarousel.min.js",
        // "assets/template/js/colorbox/jquery.colorbox-min.js",
        // "assets/template/js/tabs.js",
        // "assets/template/js/cloud_zoom.js",
        // "assets/template/js/jquery.dcjqaccordion.js",
        // "assets/template/js/custom.js",
        // "assets/template/js/html5.js"

  getGridSize() {
    return  (window.innerWidth < 320) ? 1 :
            (window.innerWidth < 600) ? 2 :
            (window.innerWidth < 800) ? 3 :
            (window.innerWidth < 900) ? 3 : 4;
  }
}
