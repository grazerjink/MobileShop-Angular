import { Component, OnInit, AfterViewInit, ViewEncapsulation } from '@angular/core';
import { log } from 'util';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class DetailComponent implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    jQuery("#related_pro").flexslider({animation: "slide",
      animationLoop: false,
      slideshow: false,
      itemWidth: 210,
      minItems: this.getGridSize(), // use function to pull in initial value
      maxItems: this.getGridSize() // use function to pull in initial value
    });
  }

  getGridSize() {
    return  (window.innerWidth < 320) ? 1 :
            (window.innerWidth < 600) ? 2 :
            (window.innerWidth < 800) ? 3 :
            (window.innerWidth < 900) ? 3 : 4;
  }

  onTabSelected(index:any) {
    console.log(index);
  }
}
