package com.slgerkamp.fpij.chapter03;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 3.8 ファイルの変更を監視
 *
 */
public class WatchFileChange {

	public static Optional<List<String>> set(String watchDirectory) {
		
		Optional<List<String>> list = Optional.empty();
		
		try {
			// 監視対象のディレクトリ
			final Path path = Paths.get(watchDirectory);
			// 監視サービス
			final WatchService watchService = 
					path.getFileSystem().newWatchService();
			// ディレクトリに変更があったときに知らせる監視サービスの登録
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
			// 監視サービスを開始、20秒間
			WatchKey watchKey = watchService.poll(20, TimeUnit.SECONDS);
			
			// 監視サービスの結果
			if(watchKey != null){
				System.out.println("evnet");
				list = Optional.of(
						watchKey.pollEvents().stream()
					.map(event -> event.toString())
					.collect(toList()));
			}
			
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
