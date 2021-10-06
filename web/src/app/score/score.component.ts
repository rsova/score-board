import {Component, OnInit} from '@angular/core';

import {Score} from '../model/score';
import {ScoreService} from '../services/score.service';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent implements OnInit {

  scores: Score[];

  constructor(private scoreService: ScoreService) {
  }

  ngOnInit() {
    this.scoreService.getScores().subscribe(data => {
      this.scores = data;
    });
  }

  public getScores(category?: string) {
    this.scoreService.getScores(category).subscribe(data => {
      this.scores = data;
    });
  }

}

