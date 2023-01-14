import { Injectable } from '@angular/core';
import {Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShareService {
  private subject = new Subject<any>();

  constructor() { }

  sendClickEvent() {
    console.log('123');
    this.subject.next();
  }
  getClickEvent(): Observable<any> {
    return this.subject.asObservable();
  }


}
