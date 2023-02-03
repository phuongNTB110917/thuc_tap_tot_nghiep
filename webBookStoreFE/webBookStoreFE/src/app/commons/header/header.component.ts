import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {BookService} from '../../user/service/book.service';
import {ShareService} from '../../user/service/share.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLogin = true;
  user: any;

  constructor(private route: ActivatedRoute,
              private bookService: BookService,
              private toastrService: ToastrService,
              private router: Router,
              private shareService: ShareService) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }

  ngOnInit() {
    this.loadHeader();
    // this.formSearch = new FormGroup({
    //   searchValue: new FormControl('', Validators.required)
    // });
  }

  loadHeader(): void {
    if (JSON.stringify(localStorage.getItem('userData') !== null)) {
      this.user = JSON.parse(localStorage.getItem('userData'));
    }
    this.isLogin = this.user != null;
    console.log(this.isLogin);
  }


  logout() {
      this.isLogin = !this.isLogin;
      localStorage.clear();
      window.location.reload();
      this.router.navigateByUrl('/');
  }
}
