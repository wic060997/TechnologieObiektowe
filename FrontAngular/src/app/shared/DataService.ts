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
  getThreeThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data3k');
  }
  getFiveThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data5k');
  }

  getTenThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data10k');
  }
  getTwentyThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data20k');
  }
  getFiftyThousendElement():Observable<any> {
    return this.http.get('http://localhost:8080/data50k');
  }

  getOneMilionElement():Observable<any> {
    return this.http.get('http://localhost:8080/data1m');
  }
  getThreeMilionElement():Observable<any> {
    return this.http.get('http://localhost:8080/data3m');
  }
  getFiveMilionElement():Observable<any> {
    return this.http.get('http://localhost:8080/data5m');
  }
  getTenMilionElement():Observable<any> {
    return this.http.get('http://localhost:8080/data10m');
  }
}
