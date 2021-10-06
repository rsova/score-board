import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {debounceTime, map, startWith, switchMap} from 'rxjs/operators';
import {User} from '../model/user';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User;
  myControl = new FormControl();
  name: string[];
  filteredNames: Observable<any>;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.filteredNames = this.myControl.valueChanges.pipe(
      startWith(''),
      debounceTime(400),
      switchMap(value => this.doFilter(value))
    );
  }

  doFilter(value: string) {
    return this.userService.getNames()
      .pipe(
        map(response => response.filter(name => {
          return name.toLowerCase().indexOf(value.toLowerCase()) === 0;
        }))
      );
  }

  getUser(name: string) {
    this.userService.getUser(name).subscribe(data => this.user = data);
  }

}
