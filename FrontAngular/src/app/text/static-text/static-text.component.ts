import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TextString } from 'src/app/shared/models/textS.model';

@Component({
  selector: 'app-static-text',
  templateUrl: './static-text.component.html',
  styleUrls: ['./static-text.component.scss'],
})
export class StaticTextComponent implements OnInit {
  private jsonURL = 'assets/text.json';
  protected staticText: string;

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get(this.jsonURL).subscribe((data) => {
      this.staticText = data[0].Text;
    });
  }

  public getJSON(): Observable<any> {
    return this.http.get(this.jsonURL);
  }
}
