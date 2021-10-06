import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ScoreComponent} from './score/score.component';
import {UserComponent} from './user/user.component';

const routes: Routes = [
  {path: '', component: ScoreComponent},
  {path: 'score', component: ScoreComponent},
  {path: 'user', component: UserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
