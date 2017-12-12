import { Directive, ElementRef } from '@angular/core';
import * as $ from 'jquery';
import 'flexslider';

@Directive({
  selector: '[flexslider]',
})
export class FlexsliderDirective {
  constructor(private el: ElementRef) {}
}
