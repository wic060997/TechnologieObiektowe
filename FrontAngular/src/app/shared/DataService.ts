import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private http: HttpClient) {}

  getOneElement():Observable<any> {
    return this.http.get('http://localhost:8080/sample');
  }

  getOneThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data1k');
  }

  getTenThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data10k');
  }

  getOneMilionElement():Observable<any> {
    return this.http.get('http://localhost:8080/data1m');
  }
}
