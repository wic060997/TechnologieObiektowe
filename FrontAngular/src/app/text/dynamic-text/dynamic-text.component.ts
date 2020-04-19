import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dynamic-text',
  templateUrl: './dynamic-text.component.html',
  styleUrls: ['./dynamic-text.component.scss']
})
export class DynamicTextComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

}
