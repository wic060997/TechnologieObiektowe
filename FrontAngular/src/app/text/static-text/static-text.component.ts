import { Component, OnInit, AfterViewInit, ChangeDetectionStrategy, AfterContentChecked } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TextString } from 'src/app/shared/models/textS.model';

@Component({
  selector: 'app-static-text',
  templateUrl: './static-text.component.html',
  styleUrls: ['./static-text.component.scss'],
})
export class StaticTextComponent implements OnInit,AfterContentChecked {
  private jsonURL = 'assets/text.json';
  public staticText: string;

  constructor(private router: Router, private http: HttpClient) {}

  ngAfterContentChecked(): void {
    console.warn('After content checked: ' + new Date().getTime());
  }

  ngOnInit(): void {
    console.warn('START TIME: ' +new Date().getTime());
    this.http.get(this.jsonURL).subscribe((data) => {
      this.staticText = data[0].Text;
    });
  }

  public getJSON(): Observable<any> {
    return this.http.get(this.jsonURL);
  }
}
